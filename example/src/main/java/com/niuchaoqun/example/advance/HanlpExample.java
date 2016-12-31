package com.niuchaoqun.example.advance;

import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.summary.TextRankKeyword;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

public class HanlpExample {

	private final static String content = "    马自达汽车公司将召回在美的19万辆CX-7跨界车，生产年份为2007-2012年车型年，召回原因在于该车型转向控制功能丧失。    美国高速公路交通安全管理局（NHTSA）在网站声明中称：“对于这类受波及的召回车辆，可能有水进入前悬架球节连接接头。”    “若水受到盐（下雪天时为防止路面积雪会喷洒盐作路面处理）的污染，那么球节连接接头可能会受到腐蚀，与下部的控制臂分离，导致转向控制丧失。”    马自达汽车公司向当局称，公司将致力于先解决在天气寒冷的美国各州售出的CX-7车型。2015年7月，马自达汽车公司因类似原因召回过2007-2014车型年的19.3万CX-9跨界车。    马自达汽车公司称，目前尚未接获CX-7车型的人员伤亡或车祸报告。马自达尚未是否接获美国外召回车型伤亡事故立即作出回复。 ";

	public static void run(String[] args) {
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
