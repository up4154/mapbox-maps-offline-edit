package com.mapbox.maps.mapbox_maps

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.mapbox.bindgen.Value
import com.mapbox.common.Logger
import com.mapbox.maps.*
import com.mapbox.maps.pigeons.FLTMapInterfaces
import java.nio.ByteBuffer
import java.util.Locale
import com.mapbox.bindgen.Value
import com.mapbox.common.NetworkRestriction
import com.mapbox.common.TileDataDomain
import com.mapbox.common.TileRegionLoadOptions
import com.mapbox.common.TileStore
import com.mapbox.common.TileStoreOptions
import com.mapbox.common.TilesetDescriptor
import com.mapbox.geojson.Polygon
import com.mapbox.maps.GlyphsRasterizationMode
import com.mapbox.maps.MapInitOptions
import com.mapbox.maps.OfflineManager
import com.mapbox.maps.Style
import com.mapbox.maps.StylePackLoadOptions
import com.mapbox.maps.TilesetDescriptorOptions
import com.mapbox.maps.TilesetDescriptorOptionsForTilesets
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import com.mapbox.maps.MapView
import org.json.JSONArray
import org.json.JSONObject


class OfflineController(private val mapView: MapView):FLTMapInterfaces.OfflineManager{

  private var offlineManager: OfflineManager = OfflineManager(MapInitOptions.getDefaultResourceOptions(mapView.context))
  private var tilesetDescriptorForStyle: TilesetDescriptor = offlineManager.createTilesetDescriptor(
    TilesetDescriptorOptions.Builder()
      .styleURI(Style.OUTDOORS)
      .minZoom(0)
      .maxZoom(16)
      .build()
  )
  private val tileStore = TileStore.create().also {
    it.setOption(
      TileStoreOptions.MAPBOX_ACCESS_TOKEN,
      TileDataDomain.MAPS,
      Value("pk.eyJ1IjoidXRzYXYwMSIsImEiOiJjbGt0bTFsdzIwMWZoM2tsb3dkZHN0M2Z6In0.NVX_ZAS6j9Jn5e_5h3Z-CQ")
    )
  }
  private lateinit var coordinateJson: JSONObject
  val tileRegionId = "Some Random String"
  override  fun cacheMapLayer(){
    val polygonJson = getPolygonJson(mapView.context,"coordinates.json" )
    val tileRegionLoadOptions = TileRegionLoadOptions.Builder()
      .geometry(Polygon.fromJson(polygonJson.toString()))
      .descriptors(listOf( tilesetDescriptorForStyle))
      .acceptExpired(true)
      .networkRestriction(NetworkRestriction.NONE)
      .build()
    val tileRegionCancelable = tileStore.loadTileRegion(
      tileRegionId,
      tileRegionLoadOptions,
      { progress ->
        // Handle the download progress
      }
    ) { expected ->
      if (expected.isValue) {
        println("Downloaded SuccessFully")
      }
    }
    expected.error?.let {
      // Handle errors that occurred during the tile region download.
    }
  }

// Cancel the download if needed
  tileRegionCancelable.cancel()

  }

  private  fun getPolygonJson(context: Context, fileName: String):JSONObject{
    try {
      val inputStream = context.assets.open(fileName)
      val size = inputStream.available()
      val buffer = ByteArray(size)
      inputStream.read(buffer)
      inputStream.close()

      val jsonStr = buffer.toString(Charsets.UTF_8)
      coordinateJson = JSONObject(jsonStr)
    } catch (e: IOException) {
      e.printStackTrace()
    }
    if(coordinateJson.has("coordinates") && coordinateJson.get("coordinates") is JSONObject) {
      return coordinateJson.getJSONObject("coordinates")
    }
    return JSONObject()
  }

}