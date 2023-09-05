package com.mapbox.maps.mapbox_maps

import android.app.Application
import android.content.Context
import android.util.Log

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.mapbox.common.Logger
import com.mapbox.maps.*
import com.mapbox.maps.pigeons.FLTMapInterfaces
import java.nio.ByteBuffer
import java.util.Locale
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
import java.io.IOException
import com.mapbox.bindgen.Value

import android.os.Bundle
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel


class OfflineLoader{

//    val channel_name="offline_method_channel"
//  override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
//    super.configureFlutterEngine(flutterEngine)
//    MethodChannel(
//      flutterEngine.dartExecutor.binaryMessenger,
//      channel_name
//    ).setMethodCallHandler { call, result ->
//      if (call.method == "cacheMapLayer") {
//        cacheMapLayer()
//        result.success("cache map layer called in  offline loader in kotlin")
//      } else {
//        result.notImplemented()
//      }
//    }
//  }
//  private val context:Context
//  private val mapView: MapView = MapView(context)

  fun cacheMapLayer(context:Context):String
  {

    println("cache map layer in called in offline controller")
     var offlineManager: OfflineManager = OfflineManager(MapInitOptions.getDefaultResourceOptions(context))
     var tilesetDescriptorForStyle: TilesetDescriptor = offlineManager.createTilesetDescriptor(
      TilesetDescriptorOptions.Builder()
        .styleURI(Style.SATELLITE_STREETS)
        .minZoom(0)
        .maxZoom(16)
        .build()
    )
     val tileStore = TileStore.create().also {
      it.setOption(
        TileStoreOptions.MAPBOX_ACCESS_TOKEN,
        TileDataDomain.MAPS,
        Value(context.getString(R.string.mapbox_access_token))

      )
    }
     val polygonJsonString = """
    {
        "type": "Polygon",
        "coordinates": [
             [
                    [
        -284.380331,
        24.3967422
      ],
      [
        -284.3026543,
        24.4663694
      ],
      [
        -283.2157803,
        21.2377824
      ],
      [
        -279.3485928,
        22.8264249
      ],
      [
        -280.9745693,
        24.6566121
      ],
      [
        -284.380331,
        24.3967422
      ]
                ]
            ]
        
    }
""".trimIndent()

    val tileRegionId = "Some Random String"
    val tileRegionLoadOptions = TileRegionLoadOptions.Builder()
      .geometry(Polygon.fromJson(polygonJsonString))
      .descriptors(listOf( tilesetDescriptorForStyle))
      .acceptExpired(true)
      .networkRestriction(NetworkRestriction.NONE)
      .build()
    val tileRegionCancelable = tileStore.loadTileRegion(
      tileRegionId,
      tileRegionLoadOptions,
      { progress ->
        println("$progress")
      }
    ) { expected ->
      if (expected.isValue) {
        println("Downloaded SuccessFully")
      }
      else{
        println("downloading not completed")
      }
    }
//    tileRegionCancelable.cancel()
    val tileRegionExisting =  tileStore.getAllTileRegions { expected ->
      if (expected.isValue) {
        expected.value?.let { tileRegionList ->
          println("Existing tile regions: $tileRegionList")

        }
      }
      expected.error?.let { tileRegionError ->
        println("TileRegionError: $tileRegionError")
      }
    }
return "cache map layer success"
  }
}