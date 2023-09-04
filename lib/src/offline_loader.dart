part of mapbox_maps_flutter;


// late final BinaryMessenger? _binaryMessenger;

Future<String> cacheMapLayer() async {
  print("cache map layer is called in map_interface.dart");
  final MethodChannel _globalChannel =
  MethodChannel("dev.flutter.pigeon.OfflineManager.cacheMapLayer");
  // final BasicMessageChannel<Object?> channel = BasicMessageChannel<Object?>(
  //     , codec,
  //     binaryMessenger: _binaryMessenger);

  final Map<Object?, Object?>? replyMap =
  await _globalChannel.invokeMethod('cacheMapLayer');
  print("$replyMap reply map in mapinterface dart");
  if (replyMap == null) {
    throw PlatformException(
      code: 'channel-error',
      message: 'Unable to establish connection on channel.',
    );
  } else if (replyMap['error'] != null) {
    final Map<Object?, Object?> error =
    (replyMap['error'] as Map<Object?, Object?>?)!;
    throw PlatformException(
      code: (error['code'] as String?)!,
      message: (error['message'] as String? ),
      details: error['details'],
    );
  } else if (replyMap['result'] == null) {
    throw PlatformException(
      code: 'null-error',
      message: 'Host platform returned null value for non-null return value.',
    );
  } else {
    return (replyMap['result'] as String?)!;
  }
}