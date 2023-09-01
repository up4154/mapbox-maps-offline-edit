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
      Value(mapView.context.getString(R.string.mapbox_access_token))

    )
  }
  private val polygonJsonString = """
    {
        "type": "Polygon",
        "coordinates": [Tuesday 1:04 pm] Karnica Parasher

{
  "shape": {
    "type": "Polygon",
    "coordinates": [
      [
        -0.871832906,
        53.077501077,
        0
      ],
      [
        -0.871820023,
        53.077495658,
        0
      ],
      [
        -0.871517289,
        53.077368384,
        0
      ],
      [
        -0.871365718,
        53.077304137,
        0
      ],
      [
        -0.871209473,
        53.077238272,
        0
      ],
      [
        -0.871203848,
        53.077242192,
        0
      ],
      [
        -0.870963392,
        53.077406752,
        0
      ],
      [
        -0.870895241,
        53.077455546,
        0
      ],
      [
        -0.870845443,
        53.077493188,
        0
      ],
      [
        -0.870840525,
        53.077497465,
        0
      ],
      [
        -0.870821309,
        53.077514174,
        0
      ],
      [
        -0.870810257,
        53.077527344,
        0
      ],
      [
        -0.870802974,
        53.077536023,
        0
      ],
      [
        -0.870790826,
        53.077555325,
        0
      ],
      [
        -0.870751377,
        53.07763109,
        0
      ],
      [
        -0.870713535,
        53.077696802,
        0
      ],
      [
        -0.870671814,
        53.077762388,
        0
      ],
      [
        -0.870633165,
        53.07781326,
        0
      ],
      [
        -0.870572479,
        53.077878151,
        0
      ],
      [
        -0.870566669,
        53.077884364,
        0
      ],
      [
        -0.870563751,
        53.077887482,
        0
      ],
      [
        -0.870487295,
        53.077956963,
        0
      ],
      [
        -0.870478885,
        53.077964614,
        0
      ],
      [
        -0.870425719,
        53.07800546,
        0
      ],
      [
        -0.870341371,
        53.07802848,
        0
      ],
      [
        -0.870144497,
        53.078130257,
        0
      ],
      [
        -0.869825375,
        53.078242918,
        0
      ],
      [
        -0.869814684,
        53.078246412,
        0
      ],
      [
        -0.869755806,
        53.078265898,
        0
      ],
      [
        -0.869694104,
        53.078284909,
        0
      ],
      [
        -0.869459586,
        53.078358999,
        0
      ],
      [
        -0.869271987,
        53.078408545,
        0
      ],
      [
        -0.869248246,
        53.078414432,
        0
      ],
      [
        -0.868973965,
        53.078496233,
        0
      ],
      [
        -0.86865838,
        53.078599036,
        0
      ],
      [
        -0.86834137,
        53.078700288,
        0
      ],
      [
        -0.868049257,
        53.078361674,
        0
      ],
      [
        -0.868014655,
        53.07831487,
        0
      ],
      [
        -0.868045355,
        53.078305454,
        0
      ],
      [
        -0.867647937,
        53.077856608,
        0
      ],
      [
        -0.867624025,
        53.077829142,
        0
      ],
      [
        -0.867577956,
        53.077844261,
        0
      ],
      [
        -0.867577073,
        53.077844553,
        0
      ],
      [
        -0.867576632,
        53.077844701,
        0
      ],
      [
        -0.867544213,
        53.07785562,
        0
      ],
      [
        -0.867495115,
        53.077872142,
        0
      ],
      [
        -0.86735773,
        53.077919556,
        0
      ],
      [
        -0.867313786,
        53.077870415,
        0
      ],
      [
        -0.867289188,
        53.077844669,
        0
      ],
      [
        -0.867089046,
        53.077622119,
        0
      ],
      [
        -0.866986711,
        53.077504417,
        0
      ],
      [
        -0.866729347,
        53.077215616,
        0
      ],
      [
        -0.866723973,
        53.077217275,
        0
      ],
      [
        -0.866723917,
        53.07721721,
        0
      ],
      [
        -0.866708258,
        53.07719947,
        0
      ],
      [
        -0.866598258,
        53.077237543,
        0
      ],
      [
        -0.86658451,
        53.077241511,
        0
      ],
      [
        -0.8665438,
        53.077252944,
        0
      ],
      [
        -0.866157258,
        53.077373664,
        0
      ],
      [
        -0.866147766,
        53.077376432,
        0
      ],
      [
        -0.866100835,
        53.077391167,
        0
      ],
      [
        -0.866013914,
        53.077421172,
        0
      ],
      [
        -0.865947995,
        53.077444986,
        0
      ],
      [
        -0.865945765,
        53.077445764,
        0
      ],
      [
        -0.86590576,
        53.077462193,
        0
      ],
      [
        -0.865865733,
        53.077480033,
        0
      ],
      [
        -0.865754972,
        53.077532239,
        0
      ],
      [
        -0.865726135,
        53.077554275,
        0
      ],
      [
        -0.865695665,
        53.077583928,
        0
      ],
      [
        -0.865680651,
        53.077625316,
        0
      ],
      [
        -0.865696504,
        53.077695288,
        0
      ],
      [
        -0.865714621,
        53.077739292,
        0
      ],
      [
        -0.865725732,
        53.077759022,
        0
      ],
      [
        -0.865746023,
        53.077784449,
        0
      ],
      [
        -0.865798144,
        53.077838199,
        0
      ],
      [
        -0.865799951,
        53.077840437,
        0
      ],
      [
        -0.865800064,
        53.077840587,
        0
      ],
      [
        -0.865809114,
        53.077851923,
        0
      ],
      [
        -0.865845538,
        53.077884919,
        0
      ],
      [
        -0.865920048,
        53.077983722,
        0
      ],
      [
        -0.866118757,
        53.078216886,
        0
      ],
      [
        -0.866223806,
        53.078325005,
        0
      ],
      [
        -0.86633167,
        53.078421428,
        0
      ],
      [
        -0.866332533,
        53.0784238,
        0
      ],
      [
        -0.866556349,
        53.078678265,
        0
      ],
      [
        -0.866593767,
        53.078714399,
        0
      ],
      [
        -0.866604542,
        53.078719087,
        0
      ],
      [
        -0.866640644,
        53.078731386,
        0
      ],
      [
        -0.866673059,
        53.07873628,
        0
      ],
      [
        -0.866693954,
        53.078736479,
        0
      ],
      [
        -0.867102765,
        53.078750711,
        0
      ],
      [
        -0.867148573,
        53.078751507,
        0
      ],
      [
        -0.867185141,
        53.078755697,
        0
      ],
      [
        -0.867230397,
        53.078761139,
        0
      ],
      [
        -0.867230903,
        53.0787612,
        0
      ],
      [
        -0.867271901,
        53.078769357,
        0
      ],
      [
        -0.867310622,
        53.078777061,
        0
      ],
      [
        -0.867345722,
        53.078791879,
        0
      ],
      [
        -0.867351968,
        53.078794521,
        0
      ],
      [
        -0.867352033,
        53.078794548,
        0
      ],
      [
        -0.867354687,
        53.078795922,
        0
      ],
      [
        -0.867387169,
        53.07881257,
        0
      ],
      [
        -0.867422391,
        53.078835958,
        0
      ],
      [
        -0.867430161,
        53.078841116,
        0
      ],
      [
        -0.867436647,
        53.078847203,
        0
      ],
      [
        -0.867457313,
        53.078866842,
        0
      ],
      [
        -0.867457356,
        53.078866884,
        0
      ],
      [
        -0.867437516,
        53.078873728,
        0
      ],
      [
        -0.867356765,
        53.078901815,
        0
      ],
      [
        -0.867336729,
        53.078908725,
        0
      ],
      [
        -0.86735139,
        53.078936013,
        0
      ],
      [
        -0.867358986,
        53.078959457,
        0
      ],
      [
        -0.867353131,
        53.078983493,
        0
      ],
      [
        -0.867338103,
        53.079004385,
        0
      ],
      [
        -0.867306709,
        53.079023144,
        0
      ],
      [
        -0.867171392,
        53.079073163,
        0
      ],
      [
        -0.867101395,
        53.079099036,
        0
      ],
      [
        -0.867008298,
        53.079096891,
        0
      ],
      [
        -0.866926038,
        53.07905152,
        0
      ],
      [
        -0.866907353,
        53.079041094,
        0
      ],
      [
        -0.866770682,
        53.078964281,
        0
      ],
      [
        -0.866712416,
        53.078937567,
        0
      ],
      [
        -0.866601153,
        53.078893808,
        0
      ],
      [
        -0.866448201,
        53.078845875,
        0
      ],
      [
        -0.866339814,
        53.078812031,
        0
      ],
      [
        -0.865984124,
        53.078713353,
        0
      ],
      [
        -0.865861053,
        53.078681615,
        0
      ],
      [
        -0.865833309,
        53.078675058,
        0
      ],
      [
        -0.86580024,
        53.078666652,
        0
      ],
      [
        -0.865633246,
        53.078641867,
        0
      ],
      [
        -0.865511096,
        53.078626229,
        0
      ],
      [
        -0.865502167,
        53.078625155,
        0
      ],
      [
        -0.86547978,
        53.078624942,
        0
      ],
      [
        -0.865458716,
        53.07862555,
        0
      ],
      [
        -0.865436305,
        53.078626235,
        0
      ],
      [
        -0.865415217,
        53.078627742,
        0
      ],
      [
        -0.865392762,
        53.078630135,
        0
      ],
      [
        -0.865377617,
        53.078632687,
        0
      ],
      [
        -0.865353497,
        53.078635963,
        0
      ],
      [
        -0.865330824,
        53.07864096,
        0
      ],
      [
        -0.865309641,
        53.078646062,
        0
      ],
      [
        -0.865286942,
        53.078652048,
        0
      ],
      [
        -0.865264049,
        53.07865974,
        0
      ],
      [
        -0.865243696,
        53.078667367,
        0
      ],
      [
        -0.865226332,
        53.078674842,
        0
      ],
      [
        -0.865197108,
        53.078690564,
        0
      ],
      [
        -0.865178818,
        53.078699199,
        0
      ],
      [
        -0.865160355,
        53.078708732,
        0
      ],
      [
        -0.865126367,
        53.078729622,
        0
      ],
      [
        -0.865112332,
        53.078741085,
        0
      ],
      [
        -0.864939904,
        53.078843626,
        0
      ],
      [
        -0.864793249,
        53.078936795,
        0
      ],
      [
        -0.864626498,
        53.079044784,
        0
      ],
      [
        -0.864612069,
        53.079054175,
        0
      ],
      [
        -0.864484091,
        53.078981937,
        0
      ],
      [
        -0.864171438,
        53.078807884,
        0
      ],
      [
        -0.864122142,
        53.078763725,
        0
      ],
      [
        -0.864007946,
        53.078701057,
        0
      ],
      [
        -0.863937507,
        53.078671798,
        0
      ],
      [
        -0.863865569,
        53.078637131,
        0
      ],
      [
        -0.863726286,
        53.078563436,
        0
      ],
      [
        -0.863610246,
        53.078514144,
        0
      ],
      [
        -0.863502026,
        53.078457016,
        0
      ],
      [
        -0.863376352,
        53.078388125,
        0
      ],
      [
        -0.863199354,
        53.078301124,
        0
      ],
      [
        -0.863132022,
        53.078272973,
        0
      ],
      [
        -0.863055967,
        53.078230265,
        0
      ],
      [
        -0.863006076,
        53.078197427,
        0
      ],
      [
        -0.862781372,
        53.078079675,
        0
      ],
      [
        -0.862606776,
        53.077986583,
        0
      ],
      [
        -0.862406745,
        53.077873022,
        0
      ],
      [
        -0.862310184,
        53.077821128,
        0
      ],
      [
        -0.862294335,
        53.077816392,
        0
      ],
      [
        -0.862272086,
        53.077805302,
        0
      ],
      [
        -0.862249647,
        53.077795738,
        0
      ],
      [
        -0.86220175,
        53.077772267,
        0
      ],
      [
        -0.862144445,
        53.077737559,
        0
      ],
      [
        -0.862101709,
        53.077716475,
        0
      ],
      [
        -0.862057433,
        53.077697174,
        0
      ],
      [
        -0.862027893,
        53.077685205,
        0
      ],
      [
        -0.861998636,
        53.077662451,
        0
      ],
      [
        -0.86197099,
        53.077635218,
        0
      ],
      [
        -0.861861972,
        53.077580239,
        0
      ],
      [
        -0.861835322,
        53.077571893,
        0
      ],
      [
        -0.861796614,
        53.077567927,
        0
      ],
      [
        -0.861774346,
        53.077563219,
        0
      ],
      [
        -0.861710977,
        53.077532049,
        0
      ],
      [
        -0.861695082,
        53.07751212,
        0
      ],
      [
        -0.861676485,
        53.077481378,
        0
      ],
      [
        -0.861552615,
        53.077423559,
        0
      ],
      [
        -0.861450846,
        53.077376739,
        0
      ],
      [
        -0.861397546,
        53.077360048,
        0
      ],
      [
        -0.86133965,
        53.077347807,
        0
      ],
      [
        -0.861305586,
        53.077337593,
        0
      ],
      [
        -0.861283365,
        53.077331087,
        0
      ],
      [
        -0.861249373,
        53.077316781,
        0
      ],
      [
        -0.86122455,
        53.077302747,
        0
      ],
      [
        -0.861183625,
        53.077275297,
        0
      ],
      [
        -0.861138358,
        53.077237018,
        0
      ],
      [
        -0.861129539,
        53.077226146,
        0
      ],
      [
        -0.861121129,
        53.07720539,
        0
      ],
      [
        -0.861107982,
        53.077194477,
        0
      ],
      [
        -0.861038576,
        53.077165855,
        0
      ],
      [
        -0.860989919,
        53.077142916,
        0
      ],
      [
        -0.860941257,
        53.077114493,
        0
      ],
      [
        -0.860826734,
        53.077064583,
        0
      ],
      [
        -0.860797957,
        53.077051992,
        0
      ],
      [
        -0.860762045,
        53.077032591,
        0
      ],
      [
        -0.861407276,
        53.07699643,
        0
      ],
      [
        -0.861460501,
        53.076992759,
        0
      ],
      [
        -0.861708701,
        53.0769781,
        0
      ],
      [
        -0.861977802,
        53.076962787,
        0
      ],
      [
        -0.863134364,
        53.076918654,
        0
      ],
      [
        -0.863218252,
        53.07691657,
        0
      ],
      [
        -0.863281804,
        53.076936829,
        0
      ],
      [
        -0.86322298,
        53.076698263,
        0
      ],
      [
        -0.863650105,
        53.07666352,
        0
      ],
      [
        -0.863794209,
        53.076650155,
        0
      ],
      [
        -0.86395484,
        53.076632722,
        0
      ],
      [
        -0.863999758,
        53.076627577,
        0
      ],
      [
        -0.864441253,
        53.076573093,
        0
      ],
      [
        -0.865444635,
        53.076449717,
        0
      ],
      [
        -0.866342792,
        53.076337016,
        0
      ],
      [
        -0.866999245,
        53.076253739,
        0
      ],
      [
        -0.86700913,
        53.076252484,
        0
      ],
      [
        -0.867286039,
        53.076218086,
        0
      ],
      [
        -0.867462723,
        53.076174642,
        0
      ],
      [
        -0.867674841,
        53.076106276,
        0
      ],
      [
        -0.868050857,
        53.075981038,
        0
      ],
      [
        -0.868360685,
        53.075875126,
        0
      ],
      [
        -0.868777631,
        53.075731488,
        0
      ],
      [
        -0.869178187,
        53.075592278,
        0
      ],
      [
        -0.869185101,
        53.075590456,
        0
      ],
      [
        -0.869284157,
        53.075607039,
        0
      ],
      [
        -0.869286703,
        53.07560958,
        0
      ],
      [
        -0.869290364,
        53.075612267,
        0
      ],
      [
        -0.869294023,
        53.075615044,
        0
      ],
      [
        -0.869298477,
        53.075615985,
        0
      ],
      [
        -0.869302896,
        53.075618229,
        0
      ],
      [
        -0.869308829,
        53.075619679,
        0
      ],
      [
        -0.869314775,
        53.075620635,
        0
      ],
      [
        -0.869319987,
        53.075621134,
        0
      ],
      [
        -0.869334152,
        53.075621718,
        0
      ],
      [
        -0.869479215,
        53.075611411,
        0
      ],
      [
        -0.869548051,
        53.075604874,
        0
      ],
      [
        -0.869619895,
        53.075597467,
        0
      ],
      [
        -0.869669189,
        53.075596137,
        0
      ],
      [
        -0.869687121,
        53.075595409,
        0
      ],
      [
        -0.869709532,
        53.075594633,
        0
      ],
      [
        -0.869730446,
        53.075594023,
        0
      ],
      [
        -0.869754323,
        53.07559425,
        0
      ],
      [
        -0.869769226,
        53.0755952,
        0
      ],
      [
        -0.869782657,
        53.075595328,
        0
      ],
      [
        -0.869796062,
        53.075596444,
        0
      ],
      [
        -0.869810938,
        53.075598384,
        0
      ],
      [
        -0.869824299,
        53.075601207,
        0
      ],
      [
        -0.869836191,
        53.075603118,
        0
      ],
      [
        -0.86985102,
        53.075606855,
        0
      ],
      [
        -0.869864357,
        53.075610578,
        0
      ],
      [
        -0.869875083,
        53.075614275,
        0
      ],
      [
        -0.869898355,
        53.075623396,
        0
      ],
      [
        -0.869917522,
        53.075632478,
        0
      ],
      [
        -0.869935906,
        53.07564299,
        0
      ],
      [
        -0.869943859,
        53.075647111,
        0
      ],
      [
        -0.869949758,
        53.075649864,
        0
      ],
      [
        -0.869957126,
        53.075653529,
        0
      ],
      [
        -0.869962882,
        53.075658888,
        0
      ],
      [
        -0.869982726,
        53.075679213,
        0
      ],
      [
        -0.870010866,
        53.075716246,
        0
      ],
      [
        -0.870018782,
        53.075727469,
        0
      ],
      [
        -0.870039687,
        53.075750051,
        0
      ],
      [
        -0.870063624,
        53.075770864,
        0
      ],
      [
        -0.870076671,
        53.075779977,
        0
      ],
      [
        -0.870119784,
        53.075809512,
        0
      ],
      [
        -0.87012627,
        53.075812675,
        0
      ],
      [
        -0.870130654,
        53.075816268,
        0
      ],
      [
        -0.870134314,
        53.075818999,
        0
      ],
      [
        -0.870137975,
        53.075821731,
        0
      ],
      [
        -0.870140669,
        53.07582715,
        0
      ],
      [
        -0.87014207,
        53.075830669,
        0
      ],
      [
        -0.870164524,
        53.075873942,
        0
      ],
      [
        -0.870208584,
        53.075941511,
        0
      ],
      [
        -0.87023672,
        53.075990141,
        0
      ],
      [
        -0.870238141,
        53.075992851,
        0
      ],
      [
        -0.870241032,
        53.075996474,
        0
      ],
      [
        -0.870245415,
        53.076000112,
        0
      ],
      [
        -0.870248157,
        53.076003733,
        0
      ],
      [
        -0.87025254,
        53.076007371,
        0
      ],
      [
        -0.870256946,
        53.076010109,
        0
      ],
      [
        -0.870262845,
        53.076012862,
        0
      ],
      [
        -0.870265762,
        53.076015497,
        0
      ],
      [
        -0.870271684,
        53.076017351,
        0
      ],
      [
        -0.870276091,
        53.07602009,
        0
      ],
      [
        -0.870311406,
        53.076033909,
        0
      ],
      [
        -0.870329176,
        53.076039382,
        0
      ],
      [
        -0.870348412,
        53.076045857,
        0
      ],
      [
        -0.87036603,
        53.076051418,
        0
      ],
      [
        -0.870386806,
        53.07605611,
        0
      ],
      [
        -0.870409076,
        53.076060726,
        0
      ],
      [
        -0.870471254,
        53.076074801,
        0
      ],
      [
        -0.870475707,
        53.076075742,
        0
      ],
      [
        -0.870481653,
        53.076076698,
        0
      ],
      [
        -0.870499708,
        53.076076959,
        0
      ],
      [
        -0.870535666,
        53.076071907,
        0
      ],
      [
        -0.870611513,
        53.076031277,
        0
      ],
      [
        -0.870658575,
        53.07600116,
        0
      ],
      [
        -0.870673733,
        53.075992314,
        0
      ],
      [
        -0.870682928,
        53.075988896,
        0
      ],
      [
        -0.870693492,
        53.075984502,
        0
      ],
      [
        -0.87070254,
        53.075980992,
        0
      ],
      [
        -0.870714573,
        53.07597751,
        0
      ],
      [
        -0.870732426,
        53.075974084,
        0
      ],
      [
        -0.870748936,
        53.075970645,
        0
      ],
      [
        -0.870768407,
        53.075968133,
        0
      ],
      [
        -0.870787878,
        53.075965621,
        0
      ],
      [
        -0.870805836,
        53.075963904,
        0
      ],
      [
        -0.870841699,
        53.075962447,
        0
      ],
      [
        -0.87102669,
        53.075955124,
        0
      ],
      [
        -0.871065491,
        53.075955493,
        0
      ],
      [
        -0.871075917,
        53.075956401,
        0
      ],
      [
        -0.871087683,
        53.075957411,
        0
      ],
      [
        -0.871098083,
        53.075959308,
        0
      ],
      [
        -0.871172316,
        53.075969002,
        0
      ],
      [
        -0.871179778,
        53.075969073,
        0
      ],
      [
        -0.871185726,
        53.075969938,
        0
      ],
      [
        -0.871194622,
        53.07597227,
        0
      ],
      [
        -0.871203541,
        53.075973703,
        0
      ],
      [
        -0.871209291,
        53.075976455,
        0
      ],
      [
        -0.871215213,
        53.075978309,
        0
      ],
      [
        -0.871227011,
        53.075983814,
        0
      ],
      [
        -0.871231858,
        53.075986827,
        0
      ],
      [
        -0.871235605,
        53.075983393,
        0
      ],
      [
        -0.871296185,
        53.076003232,
        0
      ],
      [
        -0.87140794,
        53.076040592,
        0
      ],
      [
        -0.871456893,
        53.076056931,
        0
      ],
      [
        -0.871462644,
        53.076058757,
        0
      ],
      [
        -0.871484366,
        53.076065822,
        0
      ],
      [
        -0.871526964,
        53.07608256,
        0
      ],
      [
        -0.87162047,
        53.076117966,
        0
      ],
      [
        -0.871733288,
        53.076156945,
        0
      ],
      [
        -0.871839675,
        53.07620727,
        0
      ],
      [
        -0.871955933,
        53.076261473,
        0
      ],
      [
        -0.871997845,
        53.076287364,
        0
      ],
      [
        -0.872026269,
        53.076325029,
        0
      ],
      [
        -0.872054128,
        53.076384327,
        0
      ],
      [
        -0.872046272,
        53.07643541,
        0
      ],
      [
        -0.872035337,
        53.076478599,
        0
      ],
      [
        -0.872051449,
        53.076551053,
        0
      ],
      [
        -0.872058993,
        53.076552554,
        0
      ],
      [
        -0.872077925,
        53.076556375,
        0
      ],
      [
        -0.87212964,
        53.076568147,
        0
      ],
      [
        -0.872154474,
        53.076588968,
        0
      ],
      [
        -0.872175009,
        53.076597163,
        0
      ],
      [
        -0.872285275,
        53.076644774,
        0
      ],
      [
        -0.872428048,
        53.076705188,
        0
      ],
      [
        -0.872499728,
        53.076732745,
        0
      ],
      [
        -0.87251185,
        53.076737265,
        0
      ],
      [
        -0.872591542,
        53.076766697,
        0
      ],
      [
        -0.87270645,
        53.076808058,
        0
      ],
      [
        -0.872722611,
        53.07681801,
        0
      ],
      [
        -0.872731252,
        53.076824384,
        0
      ],
      [
        -0.872741511,
        53.076831673,
        0
      ],
      [
        -0.87274734,
        53.076837122,
        0
      ],
      [
        -0.872754491,
        53.076843392,
        0
      ],
      [
        -0.872760297,
        53.07684974,
        0
      ],
      [
        -0.872766079,
        53.076856986,
        0
      ],
      [
        -0.872770392,
        53.07686332,
        0
      ],
      [
        -0.872776024,
        53.076870565,
        0
      ],
      [
        -0.872778824,
        53.076877693,
        0
      ],
      [
        -0.872781645,
        53.076884012,
        0
      ],
      [
        -0.872784105,
        53.076898418,
        0
      ],
      [
        -0.872785434,
        53.076904723,
        0
      ],
      [
        -0.872785005,
        53.076915417,
        0
      ],
      [
        -0.872783349,
        53.076921693,
        0
      ],
      [
        -0.87278152,
        53.076928867,
        0
      ],
      [
        -0.872776904,
        53.076934127,
        0
      ],
      [
        -0.872760081,
        53.076938121,
        0
      ],
      [
        -0.872745553,
        53.076996063,
        0
      ],
      [
        -0.87271446,
        53.077060708,
        0
      ],
      [
        -0.872689241,
        53.077149049,
        0
      ],
      [
        -0.872682083,
        53.077174538,
        0
      ],
      [
        -0.872658949,
        53.077196145,
        0
      ],
      [
        -0.87264871,
        53.077202655,
        0
      ],
      [
        -0.872618562,
        53.07722104,
        0
      ],
      [
        -0.872555394,
        53.077267734,
        0
      ],
      [
        -0.872515491,
        53.077296931,
        0
      ],
      [
        -0.872488949,
        53.077312419,
        0
      ],
      [
        -0.872459518,
        53.077312167,
        0
      ],
      [
        -0.872426952,
        53.077307921,
        0
      ],
      [
        -0.872394422,
        53.077301716,
        0
      ],
      [
        -0.872355488,
        53.077291503,
        0
      ],
      [
        -0.872326176,
        53.077287288,
        0
      ],
      [
        -0.872296754,
        53.077288951,
        0
      ],
      [
        -0.872241017,
        53.077296297,
        0
      ],
      [
        -0.872198235,
        53.077307694,
        0
      ],
      [
        -0.872079591,
        53.077345933,
        0
      ],
      [
        -0.872023618,
        53.077361169,
        0
      ],
      [
        -0.871980815,
        53.077374508,
        0
      ],
      [
        -0.871891572,
        53.077413017,
        0
      ],
      [
        -0.871867888,
        53.07744421,
        0
      ],
      [
        -0.871841517,
        53.077489733,
        0
      ],
      [
        -0.871832906,
        53.077501077,
        0
      ]
    ]
    }
""".trimIndent()

  val tileRegionId = "Some Random String"
   override   fun cacheMapLayer(result: FLTMapInterfaces.Result<String>){
    println("cache map layer in called in offline controller")

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
        // Handle the download progress
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
result.success("tileRegionList.toString()")
  }





//  private  fun getPolygonJson(context: Context, fileName: String):JSONObject{
//    try {
//      val inputStream = context.assets.open(fileName)
//      val size = inputStream.available()
//      val buffer = ByteArray(size)
//      inputStream.read(buffer)
//      inputStream.close()
//
//      val jsonStr = buffer.toString(Charsets.UTF_8)
//      coordinateJson = JSONObject(jsonStr)
//    } catch (e: IOException) {
//      e.printStackTrace()
//    }
//    if(coordinateJson.has("coordinates") && coordinateJson.get("coordinates") is JSONObject) {
//      println("$coordinateJson")
//      return coordinateJson.getJSONObject("coordinates")
//    }
//    return JSONObject()
//  }

}