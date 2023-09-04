// part of mapbox_maps_flutter;
//
//
// // late final BinaryMessenger? _binaryMessenger;
// MethodChannel _globalChannel =
// MethodChannel("offline-cacheMapLayer");
//
// Future<String> cacheMapLayer() async {
//   print("cache map layer is called in offlineLoader.dart");
//
//   try {
//     final String result =
//     await _globalChannel.invokeMethod('cacheMapLayer');
//     print('Result from Kotlin: $result');
//     return result;
//   } catch (e) {
//     print('Error invoking method: $e');
//     return "";
//   }
// }