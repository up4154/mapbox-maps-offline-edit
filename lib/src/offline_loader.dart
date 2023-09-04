// part of mapbox_maps_flutter;
//
// class OfflineLoader extends StatefulWidget {
//     OfflineLoader({
//       Key? key,
//       required this.bbox,
//       this.offlineLoader, this.gestureRecognizers,
//
//     }):super(key: key);
//
//     final String bbox;
//     final OfflineLoadedCallback? offlineLoader;
//     final Set<Factory<OneSequenceGestureRecognizer>>? gestureRecognizers;
//
//
//    @override
//    State<OfflineLoader> createState() => _OfflineLoaderState();
//  }
//
//  class _OfflineLoaderState extends State<OfflineLoader> {
//    final Completer<MapboxMap> _controller = Completer<MapboxMap>();
//
//    final _MapboxMapsPlatform _mapboxMapsPlatform = _MapboxMapsPlatform();
//    MapboxMap? mapboxMap;
//    @override
//    Widget build(BuildContext context) {
//      final Map<String, dynamic> creationParams = <String, dynamic>{
//        'bbox':widget.bbox,
//        'mapboxPluginVersion': '0.4.4'
//      };
//      return _mapboxMapsPlatform.buildView(
//          creationParams, onPlatformViewCreated, widget.gestureRecognizers);
//    }
//
//    @override
//    void initState() {
//      super.initState();
//    }
//
//    @override
//    void dispose() async {
//      super.dispose();
//      if (_controller.isCompleted) {
//        final controller = await _controller.future;
//        controller.dispose();
//      }
//    }
//
//    @override
//    void didUpdateWidget(OfflineLoader oldWidget) {
//      super.didUpdateWidget(oldWidget);
//    }
//    void onPlatformViewCreated(int id) {
//      _mapboxMapsPlatform.initPlatform();
//      final MapboxMap controller = MapboxMap(
//        mapboxMapsPlatform: _mapboxMapsPlatform,
//
//      );
//      _controller.complete(controller);
//      if (widget.offlineLoader != null) {
//        widget.offlineLoader!(controller);
//      }
//      mapboxMap = controller;
//    }
//  }
