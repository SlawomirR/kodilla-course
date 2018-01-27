package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Comparator;

public class WorldTestSuite {

    @Test
    public void testWorldPeopleQuantity() {
        // Given
        Country algeria = new Country("Algeria", "39_667_203");
        Country angola = new Country("Angola", "25_326_755");
        Country benin = new Country("Benin", "10_782_365");
        Country botswana = new Country("Botswana", 	/*Gaborone*/ 	"2_176_741");
        Country burkina_faso = new Country("Burkina Faso", "18_450_347 	");
        Country burundi = new Country("Burundi", "9_824_320 	");
        Country cameroon = new Country("Cameroon", "21_918_057 	");
        Country cape_verde = new Country("Cape Verde", "525_662 	");
        Country central_african_republic = new Country("Central African Republic", "	4_900_413 ");
        Country chad = new Country("Chad", " 	13_675_741 	");
        Country comoros = new Country("Comoros", "783_544 	");
        Country democratic_republic_of_the_congo = new Country("Democratic Republic of the Congo", "	77_267_269 	");
        Country djibouti = new Country("Djibouti", "961_037 	");
        Country egypt = new Country("Egypt", "88_523_985 	");
        Country equatorial_guinea = new Country("Equatorial Guinea", "	1_996_227 	");
        Country eritrea = new Country("Eritrea", " 	6_895_222 	");
        Country ethiopia = new Country("Ethiopia", "	99_391_145 	");
        Country gabon = new Country("Gabon", "	1_873_230 	");
        Country gambia = new Country("Gambia", "	2_022_474 	");
        Country ghana = new Country("Ghana", "	27_414_682 	");
        Country guinea = new Country("Guinea", "	10_935_259 	");
        Country guinea_bissau = new Country("Guinea-Bissau", " 	1_788_088");
        Country ivory_coast = new Country("Ivory Coast", "	23_126_355");
        Country kenya = new Country("Kenya", "45_533_204");
        Country lesotho = new Country("Lesotho", "	1_908_335");
        Country liberia = new Country("Liberia", " 	4_046_007");
        Country libya = new Country("Libya", "	6_278_522");
        Country madagascar = new Country("Madagascar", " 	23_043_955");
        Country malawi = new Country("Malawi", "	16_307_685");
        Country mali = new Country("Mali", " 	17_796_125");
        Country mauritania = new Country("Mauritania", " 	3_632_657");
        Country mauritius = new Country("Mauritius", " 	1_263_916");
        Country morocco = new Country("Morocco", "34_380_277");
        Country mozambique = new Country("Mozambique", " 	28_013_037");
        Country namibia = new Country("Namibia", "2_281_238");
        Country niger = new Country("Niger", "	18_880_785");
        Country nigeria = new Country("Nigeria", "	186_202_652");
        Country republic_of_the_congo = new Country("Republic of the Congo", "	4_706_257");
        Country rwanda = new Country("Rwanda", "1_324_426");
        Country sao_tome_and_principe = new Country("São Tomé and Príncipe", "	194_000");
        Country senegal = new Country("Senegal", "14_150_852");
        Country seychelles = new Country("Seychelles", "	970_457");
        Country sierra_leone = new Country("Sierra Leone", "	6_513_357");
        Country somalia = new Country("Somalia", "	10_972_148");
        Country south_africa = new Country("South Africa", " 	5_495_724");
        Country south_sudan = new Country("South Sudan", "	12_519_321");
        Country sudan = new Country("Sudan", "	42_235_712");
        Country swaziland = new Country("Swaziland", "	1_119_524");
        Country tanzania = new Country("Tanzania", "	51_046_045");
        Country togo = new Country("Togo", "	7_065_418");
        Country tunisia = new Country("Tunisia", "	11_118_759");
        Country uganda = new Country("Uganda", "	37_102_024");
        Country zambia = new Country("Zambia", " 	15_474_644");
        Country zimbabwe = new Country("Zimbabwe", " 	13_503_963");

        Country afghanistan = new Country("Afghanistan", "	30_419_928");
        Country armenia = new Country("Armenia", "	3_229_900");
        Country azerbaijan = new Country("Azerbaijan", "	9_493_600");
        Country bahrain = new Country("Bahrain", "1_248_348");
        Country bangladesh = new Country("Bangladesh", "	158_039_000");
        Country bhutan = new Country("Bhutan", " 	766_896");
        Country brunei = new Country("Brunei", " 	428_786");
        Country cambodia = new Country("Cambodia", " 	15_052_665");
        Country china = new Country("China", "	1_373_239_923");
        Country cyprus = new Country("Cyprus", "	1_099_341");
        Country east_timor = new Country("East Timor", "	1_143_667");
        Country georgia = new Country("Georgia", "	4_661_473");
        Country india = new Country("India", "	1_290_193_422");
        Country indonesia = new Country("Indonesia", "	248_645_008");
        Country iran = new Country("Iran", "78_868_711");
        Country iraq = new Country("Iraq", "	36_129_225");
        Country israel = new Country("Israel", "	8_502_900");
        Country japan = new Country("Japan", " 	127_368_088");
        Country jordan = new Country("Jordan", "	6_508_887");
        Country kazakhstan = new Country("Kazakhstan", "	17_522_010");
        Country kuwait = new Country("Kuwait", "	4_146_314");
        Country kyrgyzstan = new Country("Kyrgyzstan", "	5_496_737");
        Country laos = new Country("Laos", " 	6_586_266");
        Country lebanon = new Country("Lebanon", "	4_140_289");
        Country malaysia = new Country("Malaysia", " 	31_179_952");
        Country maldives = new Country("Maldives", "	394_451");
        Country mongolia = new Country("Mongolia", "	3_179_997");
        Country myanmar = new Country("Myanmar", "	54_584_650");
        Country nepal = new Country("Nepal", " 	29_890_686");
        Country north_korea = new Country("North Korea", "24_589_122");
        Country oman = new Country("Oman", " 	3_090_150");
        Country pakistan = new Country("Pakistan", "	190_291_129");
        Country philippines = new Country("Philippines", " 	103_224_000");
        Country qatar = new Country("Qatar", " 	1_951_591");
        Country saudi_arabia = new Country("Saudi Arabia", "	31_534_504");
        Country singapore = new Country("Singapore", "	5_535_000");
        Country south_korea = new Country("South Korea", "	50_004_441");
        Country sri_lanka = new Country("Sri Lanka", "	21_481_334");
        Country syria = new Country("Syria", "	22_530_746");
        Country tajikistan = new Country("Tajikistan", "	7_768_385");
        Country thailand = new Country("Thailand", " 	67_091_089");
        Country turkmenistan = new Country("Turkmenistan", "	5_054_828");
        Country united_arab_emirates = new Country("United Arab Emirates", " 	5_314_317");
        Country uzbekistan = new Country("Uzbekistan", "	28_394_180");
        Country vietnam = new Country("Vietnam", "	91_519_289");
        Country yemen = new Country("Yemen", "	24_771_809");

        Country australiaCountry = new Country("Australia", "24_255_949");
        Country new_zealand = new Country("New Zealand", "	4_727_459");
        Country papua_new_guinea = new Country("Papua New Guinea", "	7_321_589");
        Country fiji = new Country("Fiji", 	"909_389");
        Country kiribati = new Country("Kiribati", 	"103_245");
        Country marshall_islands = new Country("Marshall Islands", 	"52_879");
        Country federated_states_of_micronesia = new Country("Federated States of Micronesia", 	"106_348");
        Country nauru = new Country("Nauru", 	"10_084");
        Country palau = new Country("Palau", 	"17_948");
        Country samoa = new Country("Samoa", 	"194_899");
        Country solomonIslands = new Country("SolomonIslands",  "	539_241");
        Country tonga = new Country("Tonga", 	"103_036");
        Country tuvalu = new Country("Tuvalu", "10_647");
        Country vanuatu = new Country("Vanuatu", 	"243_304");

        Country albania = new Country("Albania", "2_831_741");
        Country andorra = new Country("Andorra", "68_403");
        Country austria = new Country("Austria", "	8_169_929");
        Country belarus = new Country("Belarus", " 	9_458_047");
        Country belgium = new Country("Belgium", "	11_007_785");
        Country bosnia_and_herzegovina = new Country("Bosnia and Herzegovina", "	3_843_126");
        Country bulgaria = new Country("Bulgaria", "	7_621_337");
        Country croatia = new Country("Croatia", "	4_437_460");
        Country czech_republic = new Country("Czech Republic", "	10_256_760");
        Country denmark = new Country("Denmark", "	5_564_219");
        Country estonia = new Country("Estonia", "	1_340_194");
        Country finland = new Country("Finland", "	5_157_537");
        Country france = new Country("France", "	66_104_554");
        Country germany = new Country("Germany", "	80_716_124");
        Country greece = new Country("Greece", "	11_123_034");
        Country hungary = new Country("Hungary", "	10_075_034");
        Country iceland = new Country("Iceland", "307_261");
        Country ireland = new Country("Ireland", "4_234_925");
        Country italy = new Country("Italy", "	60_655_464");
        Country kosovo = new Country("Kosovo", "	1_844_715");
        Country latvia = new Country("Latvia", "2_067_900");
        Country liechtenstein = new Country("Liechtenstein", "	32_842");
        Country lithuania = new Country("Lithuania", "	2_988_400");
        Country luxembourg = new Country("Luxembourg", "	448_569");
        Country macedonia = new Country("Macedonia", "	2_054_800");
        Country malta = new Country("Malta", " 	397_499");
        Country moldova = new Country("Moldova", " 	4_434_547");
        Country monaco = new Country("Monaco", "	31_987");
        Country montenegro = new Country("Montenegro", " 	616_258");
        Country netherlands = new Country("Netherlands", "	16_902_103");
        Country norway = new Country("Norway", " 	5_018_836");
        Country poland = new Country("Poland", "	38_625_478");
        Country portugal = new Country("Portugal", "	10_409_995");
        Country romania = new Country("Romania", "	21_698_181");
        Country russia = new Country("Russia", "	143_975_923");
        Country san_marino = new Country("San Marino", " 	27_730");
        Country serbia = new Country("Serbia", "	7_120_666");
        Country slovakia = new Country("Slovakia", " 	5_422_366");
        Country slovenia = new Country("Slovenia", "	2_050_189");
        Country spain = new Country("Spain", " 	47_059_533");
        Country sweden = new Country("Sweden", " 	9_090_113");
        Country switzerland = new Country("Switzerland", "	7_507_475");
        Country turkey = new Country("Turkey", "	79_749_461");
        Country ukraine = new Country("Ukraine", "45_360_224");
        Country united_kingdom = new Country("United Kingdom", "	65_110_274");
        Country vatican_city = new Country("Vatican City", "	900");

        Country antigua_and_barbuda = new Country("Antigua and Barbuda", "	88_057");
        Country bahamas = new Country("Bahamas", "	369_670");
        Country barbados = new Country("Barbados", "	277_821");
        Country belize = new Country("Belize", "	368_310");
        Country canada = new Country("Canada", "	36_851_774");
        Country costa_rica = new Country("Costa Rica", "	4_832_234");
        Country cuba = new Country("Cuba", "	11_204_000");
        Country dominica = new Country("Dominica", "67_117");
        Country dominican_republic = new Country("Dominican Republic", "	10_911_819");
        Country el_salvador = new Country("El Salvador", "	6_163_000");
        Country grenada = new Country("Grenada", "	10_437");
        Country guatemala = new Country("Guatemala", "	16_176_133");
        Country haiti = new Country("Haiti", "	10_033_254");
        Country honduras = new Country("Honduras", "	8_576_500");
        Country jamaica = new Country("Jamaica", "	2_719_814");
        Country mexico = new Country("Mexico", "	114_322_757");
        Country nicaragua = new Country("Nicaragua", "	6_071_045");
        Country panama = new Country("Panama", "	3_454_698");
        Country saint_kitts_and_nevis = new Country("Saint Kitts and Nevis", "	52_249");
        Country saint_lucia = new Country("Saint Lucia", "	172_746");
        Country saint_vincent_and_the_grenadines = new Country("Saint Vincent and the Grenadines", "	109_088");
        Country trinidad_and_tobago = new Country("Trinidad and Tobago", "1_339_002");
        Country united_states_of_america = new Country("United States of America", "329_314_000");

        Country argentina = new Country("Argentina", " 	40_482_489");
        Country bolivia = new Country("Bolivia", " 	9_863_224");
        Country brazil = new Country("Brazil", "	202_241_714");
        Country chile = new Country("Chile", "	16_928_873");
        Country colombia = new Country("Colombia", " 	46_920_257");
        Country ecuador = new Country("Ecuador", "	14_573_101");
        Country guyana = new Country("Guyana", " 	772_298");
        Country paraguay = new Country("Paraguay", "	6_831_306");
        Country peru = new Country("Peru", "29_132_013");
        Country suriname = new Country("Suriname", "	472_155");
        Country uruguay = new Country("Uruguay", "3_477_780");
        Country venezuela = new Country("Venezuela", "	31_768_930");

        Continent africa = new Continent("Africa", Arrays.asList(algeria, angola, benin, botswana, burkina_faso,
                burundi, cameroon, cape_verde, central_african_republic, chad, comoros, democratic_republic_of_the_congo,
                djibouti, egypt, equatorial_guinea, eritrea, ethiopia, gabon, gambia, ghana, guinea, guinea_bissau,
                ivory_coast, kenya, lesotho, liberia, libya, madagascar, malawi, mali, mauritania, mauritius, morocco,
                mozambique, namibia, niger, nigeria, republic_of_the_congo, rwanda, sao_tome_and_principe, senegal,
                seychelles, sierra_leone, somalia, south_africa, south_sudan, sudan, swaziland, tanzania, togo,
                tunisia, uganda, zambia, zimbabwe)
        );

        Continent asia = new Continent("Asia", Arrays.asList(afghanistan, armenia, azerbaijan, bahrain, bangladesh,
                bhutan, brunei, cambodia, china, cyprus, east_timor, georgia, india, indonesia, iran, iraq, israel, japan,
                jordan, kazakhstan, kuwait, kyrgyzstan, laos, lebanon, malaysia, maldives, mongolia, myanmar, nepal,
                north_korea, oman, pakistan, philippines, qatar, saudi_arabia, singapore, south_korea, sri_lanka, syria,
                tajikistan, thailand, turkmenistan, united_arab_emirates, uzbekistan, vietnam, yemen)
        );

        Continent australia = new Continent("Australia", Arrays.asList(australiaCountry, new_zealand,
                papua_new_guinea, fiji, kiribati, marshall_islands, federated_states_of_micronesia, nauru, palau, samoa,
                solomonIslands, tonga, tuvalu, vanuatu)
        );

        Continent europe = new Continent("Europe", Arrays.asList(albania, andorra, austria, belarus, belgium,
                bosnia_and_herzegovina, bulgaria, croatia, czech_republic, denmark, estonia, finland, france,
                germany, greece, hungary, iceland, ireland, italy, kosovo, latvia, liechtenstein, lithuania,
                luxembourg, macedonia, malta, moldova, monaco, montenegro, netherlands, norway, poland,
                portugal, romania, russia, san_marino, serbia, slovakia, slovenia, spain, sweden, switzerland,
                turkey, ukraine, united_kingdom, vatican_city)
        );

        Continent northAmerica = new Continent("North_America", Arrays.asList(antigua_and_barbuda, bahamas, barbados,
                belize, canada, costa_rica, cuba, dominica, dominican_republic, el_salvador, grenada, guatemala,
                haiti, honduras, jamaica, mexico, nicaragua, panama, saint_kitts_and_nevis, saint_lucia,
                saint_vincent_and_the_grenadines, trinidad_and_tobago, united_states_of_america)
        );

        Continent southAmerica = new Continent("South_America", Arrays.asList(argentina, bolivia, brazil,
                chile, colombia, ecuador, guyana, paraguay, peru, suriname, uruguay, venezuela)
        );

        World worldListContinents = new World(Arrays.asList(africa, asia, australia, europe, northAmerica, southAmerica));

        // Unimportant
        int longestCountryName = worldListContinents.getListOfContinents().stream()
                .flatMap(s -> s.getListOfCountries().stream())
                .mapToInt(c -> c.getCountryName().length())
                .reduce(Integer::max).getAsInt();
        System.out.println("Size of the longest country name: " + longestCountryName);
        worldListContinents.getListOfContinents().stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .sorted(Comparator.comparing(s -> s.getPeopleQuantity()))
                .forEach(s -> System.out.println(s.printCountryInfo(longestCountryName)));

        //When
        BigDecimal bigDecimal = worldListContinents.getPeopleQuantity();

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        DecimalFormat formattedNumber = new DecimalFormat("###,###.##", symbols);
        System.out.println("\nThere are at least " + formattedNumber.format(bigDecimal) + " people in the world");

        //Then
        Assert.assertEquals(7180179761L, bigDecimal.longValue());
    }
}
