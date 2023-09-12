

import Foundation

import ADPUtilities
class OfflineLoader {


func cacheMapLayer(){
    print("Hello for cache map layer")
}

//    fun cacheMapLayer(){
//
//    let options = StylePackLoadOptions(glyphsRasterizationMode: .ideographsRasterizedLocally,
//                                       ,acceptExpired: true)
//
//    tileStore.setOptionForKey(TileStoreOptions.mapboxAccessToken, value: accessToken as Any)
//
//    let offlineManager = OfflineManager(resourceOptions: ResourceOptions(accessToken: accessToken,
//                                                                      tileStore: tileStore))
//
// // 1. Create the tile set descriptor
//    let options = TilesetDescriptorOptions(styleURI: .outdoors, zoomRange: 0...16)
//    let tilesetDescriptor = offlineManager.createTilesetDescriptor(for: options)
//
// // 2. Create the TileRegionLoadOptions
//    let tileRegionLoadOptions = TileRegionLoadOptions(
//     geometry: Geometry(coordinate: tokyoCoord),
//     descriptors: [tilesetDescriptor],
//     acceptExpired: true)
//
//    let tileRegionId = "my-tile-region-id"
//
// // Load the tile region
//    let tileRegionLoadOptions = TileRegionLoadOptions(
//     geometry: Geometry(coordinate: tokyoCoord),
//     descriptors: [tilesetDescriptor],
//     acceptExpired: true)!
//
//    let tileRegionCancelable = tileStore.loadTileRegion(
//     forId: tileRegionId,
//     loadOptions: tileRegionLoadOptions) { _ in
//     //
//     // Handle progress here
//     //
//     } completion: { result in
//     //
//     // Handle TileRegion result
//     //
//     switch result {
//     case let .success(tileRegion):
//         // Tile region download finishes successfully
//         print("Process \(tileRegion)")
//
//     case let .failure(error):
//         // Handle error occurred during the tile region download
//         if case TileRegionError.canceled = error {
//             handleCancelation()
//         } else {
//             handleFailure(error)
//         }
//     }
//     }
//
//     tileStore.allTileRegions { result in
//     switch result {
//     case let .success(tileRegions):
//         handleTileRegions(tileRegions)
//
//     case let .failure(error) where error is TileRegionError:
//         handleTileRegionError(error)
//
//     case .failure(_):
//         handleFailure()
//     }
//   }

}