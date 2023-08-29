part of mapbox_maps_flutter;


extension OfflineLoading on OfflineManager{
  Future<void> loadOfflineData() {
    return cacheMapLayer();
  }
}