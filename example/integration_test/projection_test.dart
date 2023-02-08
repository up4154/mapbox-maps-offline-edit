import 'package:flutter_test/flutter_test.dart';
import 'package:integration_test/integration_test.dart';
import 'package:mapbox_maps_flutter/mapbox_maps_flutter.dart';
import 'package:mapbox_maps_example/empty_map_widget.dart' as app;

void main() {
  IntegrationTestWidgetsFlutterBinding.ensureInitialized();

  testWidgets('getMetersPerPixelAtLatitude', (WidgetTester tester) async {
    final mapFuture = app.main();
    await tester.pumpAndSettle();

    final mapboxMap = await mapFuture;
    var meters =
        await mapboxMap.projection.getMetersPerPixelAtLatitude(1.0, 16.0);
    expect(meters.round(), 1);
  });

  testWidgets('projectedMetersForCoordinate', (WidgetTester tester) async {
    final mapFuture = app.main();
    await tester.pumpAndSettle();

    final mapboxMap = await mapFuture;
    var projectedMeters =
        await mapboxMap.projection.projectedMetersForCoordinate(Point(
            coordinates: Position(
      1.0,
      60,
    )).toJson());
    expect(projectedMeters.easting.floor(), 111195);
    expect(projectedMeters.northing.floor(), 8390350);
  });

  testWidgets('coordinateForProjectedMeters', (WidgetTester tester) async {
    final mapFuture = app.main();
    await tester.pumpAndSettle();

    final mapboxMap = await mapFuture;
    var point = await mapboxMap.projection.coordinateForProjectedMeters(
        ProjectedMeters(northing: 100000.0, easting: 100000.0));
    var coordinates = point['coordinates'] as List<Object?>;
    expect(coordinates.length, 2);
    expect((coordinates.first as double).floor(), 0);
    expect((coordinates.last as double).floor(), 0);
  });

  testWidgets('unproject', (WidgetTester tester) async {
    final mapFuture = app.main();
    await tester.pumpAndSettle();

    final mapboxMap = await mapFuture;
    var point = await mapboxMap.projection
        .unproject(MercatorCoordinate(x: 1.0, y: 1.0), 16);
    var coordinates = point['coordinates'] as List<Object?>;
    expect(coordinates.length, 2);
    expect((coordinates.first as double).floor(), -180);
    expect((coordinates.last as double).floor(), 85);
  });

  testWidgets('project', (WidgetTester tester) async {
    final mapFuture = app.main();
    await tester.pumpAndSettle();

    final mapboxMap = await mapFuture;
    var mercatorCoordinate = await mapboxMap.projection.project(
        Point(
            coordinates: Position(
          1.0,
          60,
        )).toJson(),
        16);
    expect(mercatorCoordinate.x.floor(), 4118);
    expect(mercatorCoordinate.y.floor(), 2378);
  });
}
