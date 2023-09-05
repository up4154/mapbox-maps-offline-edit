part of mapbox_maps_flutter;


final MethodChannel _offlineChannel= MethodChannel("offline_method_channel");


Future<String>getOfflineRegion() async{
  final result = await _offlineChannel.invokeMethod("cacheMapLayer");
  if(result==null){
    print("result is null");
  }
  print(result);
  return(result);
}