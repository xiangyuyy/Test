package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2019/12/1013:57
 */
public class TestThread {
    public static void main(String[] args) {
        String nowDateStr = LocalDate.now().toString();
        System.out.println("---------" + nowDateStr);
        System.out.println("---------" + LocalDateTime.now());
        System.out.println("---------" + LocalTime.now());

        String message = "{\n" +
                "\t\"streams\": [{\n" +
                "\t\t\"index\": 0,\n" +
                "\t\t\"codec_name\": \"h264\",\n" +
                "\t\t\"codec_long_name\": \"H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10\",\n" +
                "\t\t\"codec_type\": \"video\",\n" +
                "\t\t\"codec_time_base\": \"0/2\",\n" +
                "\t\t\"start_time\": \"0.491000\",\n" +
                "\t\t\"duration\": \"5.036000\",\n" +
                "\t\t\"bit_rate\": \"\",\n" +
                "\t\t\"nb_frames\": \"\",\n" +
                "\t\t\"profile\": \"High\",\n" +
                "\t\t\"width\": 544,\n" +
                "\t\t\"height\": 960,\n" +
                "\t\t\"coded_width\": 544,\n" +
                "\t\t\"coded_height\": 960,\n" +
                "\t\t\"level\": 31,\n" +
                "\t\t\"refs\": 1,\n" +
                "\t\t\"pix_fmt\": \"yuv420p\",\n" +
                "\t\t\"r_frame_rate\": \"25/1\",\n" +
                "\t\t\"avg_frame_rate\": \"0/0\",\n" +
                "\t\t\"field_order\": \"progressive\",\n" +
                "\t\t\"tags\": {},\n" +
                "\t\t\"Disposition\": {\n" +
                "\t\t\t\"attached_pic\": 0\n" +
                "\t\t}\n" +
                "\t}, {\n" +
                "\t\t\"index\": 1,\n" +
                "\t\t\"codec_name\": \"aac\",\n" +
                "\t\t\"codec_long_name\": \"AAC (Advanced Audio Coding)\",\n" +
                "\t\t\"codec_type\": \"audio\",\n" +
                "\t\t\"codec_time_base\": \"1/48000\",\n" +
                "\t\t\"start_time\": \"0.826000\",\n" +
                "\t\t\"duration\": \"4.672000\",\n" +
                "\t\t\"bit_rate\": \"75750\",\n" +
                "\t\t\"nb_frames\": \"\",\n" +
                "\t\t\"profile\": \"LC\",\n" +
                "\t\t\"r_frame_rate\": \"0/0\",\n" +
                "\t\t\"avg_frame_rate\": \"0/0\",\n" +
                "\t\t\"sample_fmt\": \"s16p\",\n" +
                "\t\t\"sample_rate\": \"48000\",\n" +
                "\t\t\"channels\": 1,\n" +
                "\t\t\"tags\": {},\n" +
                "\t\t\"Disposition\": {\n" +
                "\t\t\t\"attached_pic\": 0\n" +
                "\t\t}\n" +
                "\t}],\n" +
                "\t\"format\": {\n" +
                "\t\t\"nb_streams\": 2,\n" +
                "\t\t\"format_name\": \"hls,applehttp\",\n" +
                "\t\t\"format_long_name\": \"Apple HTTP Live Streaming\",\n" +
                "\t\t\"start_time\": \"0.491000\",\n" +
                "\t\t\"duration\": \"320.028\",\n" +
                "\t\t\"size\": \"6955\",\n" +
                "\t\t\"bit_rate\": \"2287656\",\n" +
                "\t\t\"tags\": {}\n" +
                "\t}\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(message);
        JSONObject jsonObject1= jsonObject.getJSONObject("format");
        String jsonObject2 = jsonObject1.getString("duration");
        BigDecimal bigDecimal = new BigDecimal(jsonObject2);
        Integer integer = bigDecimal.intValue();
        System.out.println("---------" + bigDecimal);

        List<Integer> list  = new ArrayList<>();
        long time = System.currentTimeMillis();
        for(int i =0;i<10000000;i++){
            list.add(i);
        }
        long time1 = System.currentTimeMillis();
        System.out.println("---------插入" + (time1-time));

        long time2 = System.currentTimeMillis();
        Integer direct = list.stream().filter(x -> x ==9000000 ).collect(Collectors.toList()).size();
        long time3 = System.currentTimeMillis();
        System.out.println("---------查询" + (time3-time2));

        String prizeValue = "5";
        BigDecimal bigDecimal1 = new BigDecimal(prizeValue);


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(date);
        Date today = null;
        try {
            today = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            return;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, +1);
        Date tomarrow = c.getTime();//明天
        System.out.printf("1");
    }
}
