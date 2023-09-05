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


class MainActivity: FlutterActivity(){
    val channel_name="offline_method_channel"
  override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
    super.configureFlutterEngine(flutterEngine)
    MethodChannel(
      flutterEngine.dartExecutor.binaryMessenger,
      channel_name
    ).setMethodCallHandler { call, result ->
      if (call.method == "cacheMapLayer") {
//        cacheMapLayer()
        result.success("cache map layer called in  offline loader in kotlin")
      } else {
        result.notImplemented()
      }
    }
  }
//  private val mapView: MapView = MapView(this)
//  private var offlineManager: OfflineManager = OfflineManager(MapInitOptions.getDefaultResourceOptions(mapView.context))
//  private var tilesetDescriptorForStyle: TilesetDescriptor = offlineManager.createTilesetDescriptor(
//    TilesetDescriptorOptions.Builder()
//      .styleURI(Style.OUTDOORS)
//      .minZoom(0)
//      .maxZoom(16)
//      .build()
//  )
//  private val tileStore = TileStore.create().also {
//    it.setOption(
//      TileStoreOptions.MAPBOX_ACCESS_TOKEN,
//      TileDataDomain.MAPS,
//      Value(mapView.context.getString(R.string.mapbox_access_token))
//
//    )
//  }
//  private val polygonJsonString = """
//    {
//        "type": "Polygon",
//        "coordinates": [
//             [
//                    [-122.41857910156249, 37.76023484134737],
//                    [-122.42177963256836, 37.75422679365761],
//                    [-122.40983009338379, 37.75363563119239],
//                    [-122.40655899047852, 37.75897167811799],
//                    [-122.41857910156249, 37.76023484134737]
//                ]
//            ]
//
//    }
//""".trimIndent()
//
//  val tileRegionId = "Some Random String"
//  fun cacheMapLayer(){
//    println("cache map layer in called in offline controller")
//
//    val tileRegionLoadOptions = TileRegionLoadOptions.Builder()
//      .geometry(Polygon.fromJson(polygonJsonString))
//      .descriptors(listOf( tilesetDescriptorForStyle))
//      .acceptExpired(true)
//      .networkRestriction(NetworkRestriction.NONE)
//      .build()
//    val tileRegionCancelable = tileStore.loadTileRegion(
//      tileRegionId,
//      tileRegionLoadOptions,
//      { progress ->
//        println("$progress")
//      }
//    ) { expected ->
//      if (expected.isValue) {
//        println("Downloaded SuccessFully")
//      }
//      else{
//        println("downloading not completed")
//      }
//    }
////    tileRegionCancelable.cancel()
//    val tileRegionExisting =  tileStore.getAllTileRegions { expected ->
//      if (expected.isValue) {
//        expected.value?.let { tileRegionList ->
//          println("Existing tile regions: $tileRegionList")
//
//        }
//      }
//      expected.error?.let { tileRegionError ->
//        println("TileRegionError: $tileRegionError")
//      }
//    }
//
//  }
}