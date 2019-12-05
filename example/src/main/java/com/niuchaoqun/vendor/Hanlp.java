package com.niuchaoqun.vendor;

import java.util.List;

import com.hankcs.hanlp.HanLP;

public class Hanlp {

    private final static String content = "相传，在古时候，有个名叫万年的青年，看到当时节令很乱，就有了想把节令定准的打算。但是苦于找不到计算时间的方法，一天，他上山砍柴累了，坐在树阴下休息，树影的移动启发了他，他设计了一个测日影计天时的晷仪，测定一天的时间，后来，山崖上的滴泉启发了他的灵感，他又动手做了一个五层漏壶，来计算时间。天长日久，他发现每隔三百六十多天，四季就轮回一次，天时的长短就重复一遍。\n" +
            "当时的国君叫祖乙，也常为天气风云的不测感到苦恼。万年知道后，就带着日晷和漏壶去见皇上，对祖乙讲清了日月运行的道理。祖乙听后龙颜大悦，感到有道理。于是把万年留下，在天坛前修建日月阁，筑起日晷台和漏壶亭。并希望能测准日月规律，推算出准确的晨夕时间，创建历法，为天下的黎民百姓造福。\n" +
            "有一次，祖乙去了解万年测试历法的进展情 [1]  况。当他登上日月坛时，看见天坛边的石壁上刻着一首诗：\n" +
            "日出日落三百六，周而复始从头来。\n" +
            "草木枯荣分四时，一岁月有十二圆。\n" +
            "知道万年创建历法已成，亲自登上日月阁看望万年。万年指着天象，对祖乙说：“现在正是十二个月满，旧岁已完，新春复始，祈请国君定个节吧”。祖乙说：“春为岁首，就叫春节吧”。据说这就是春节的来历。\n" +
            "冬去春来，年复一年，万年经过长期观察，精心推算，制定出了准确的太阳历，当他把太阳历呈奉给继任的国君时，已是满面银须。国君深为感动，为纪念万年的功绩，便将太阳历命名为“万年历”，封万年为日月寿星。以后，人们在过年时挂上寿就是为了纪念德高望重的万年。";

	public static void main(String[] args) {
		example();
	}

	public static void example() {
		List<String> keywordList = HanLP.extractKeyword(content, 10);
		List<String> parse = HanLP.extractPhrase(content, 10);
		System.out.println(keywordList);
		System.out.println(parse);
		System.out.println("=====");

	}

	public static void ab() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			List<String> keywordList = HanLP.extractKeyword(content, 10);
			List<String> parse = HanLP.extractPhrase(content, 10);
		}
		//System.out.println(end - start);
	}
}
