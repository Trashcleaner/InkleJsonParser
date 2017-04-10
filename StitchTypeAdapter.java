import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import gson_objects.*;
import model.Stitch;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by obrusvit on 9.4.17.
 */
public class StitchTypeAdapter extends TypeAdapter<Stitch> {

    @Override
    public Stitch read(JsonReader jsonReader) throws IOException {
        final Stitch stitch = new Stitch();

        //PREPARE STITCH CONTENTS TO BE LOADED
        String name = null;
        String text = null;
        ArrayList<OptionGson> options = null;
        IfConditionGson ifCondition = null;
        NotIfConditionGson notIfCondition = null;
        DivertGson divertName = null;
        FlagNameGson flagName = null;
        PageLabelGson pageLabel = null;
        PageNumGson pageNum = null;
        RunOnGson runOn = null;

        //START PARSING
        jsonReader.beginObject();
        name = jsonReader.nextName();

        jsonReader.beginObject();
        jsonReader.skipValue(); //content

        jsonReader.beginArray();
        text = jsonReader.nextString(); //actual text

        //PARSING CONTENT ARRAY
        while(jsonReader.hasNext()){
            if(jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)){
                jsonReader.beginObject();
                while(jsonReader.hasNext()){
                    //System.out.println(jsonReader.peek());
                    if(jsonReader.peek().equals(JsonToken.NAME)) {
                        String var = jsonReader.nextName();
                        switch (var){
                            case "ifConditions":
                            case "notIfConditions":
                            case "option":
                            case "linkPath":
                                System.out.println("Consuming Option");
                                //OptionGson option= readOption(jsonReader);
                                //options.add(option);
                                break;
                            case "divert":
                                System.out.println("Consuming divert");
                                divertName = readDivert(jsonReader);
                                break;

                            case "flagName":
                                System.out.println("Consuming FlagName");
                                flagName = readFlagName(jsonReader);
                                break;

                            case "pageNum":
                                System.out.println("Consuming PageNum");
                                //pageNum = readPageNum(jsonReader);
                                break;
                            case "pageLabel":
                                System.out.println("Consuming PageLabel");
                                //pageLabel = readPageLabel(jsonReader);
                                break;
                            case "runOn":
                                System.out.println("Consuming runOn");
                                runOn = readRunOn(jsonReader);
                            default:
                                //System.out.println("BLAg");
                                break;
                        }

                    }
                    jsonReader.skipValue(); //toto pujde prych po implementaci read* methods
                }
                jsonReader.endObject();
            }

        }

        jsonReader.endArray();


        jsonReader.endObject();
        jsonReader.endObject();

        stitch.setName(name);
        stitch.setText(text);
        stitch.setOptions(options);
        stitch.setIfCondition(ifCondition);
        stitch.setNotIfCondition(notIfCondition);
        stitch.setDivertName(divertName);
        stitch.setFlagName(flagName);
        stitch.setPageLabel(pageLabel);
        stitch.setPageName(pageNum);
        stitch.setRunOn(runOn);

        return stitch;
    }

    private FlagNameGson readFlagName(JsonReader jsonReader) throws IOException{
        FlagNameGson ret = new FlagNameGson();
        ret.setFlagName(jsonReader.nextString());
        return ret;

    }

    private DivertGson readDivert(JsonReader jsonReader) throws IOException {
        DivertGson ret = new DivertGson();
        String s = jsonReader.nextString();
        ret.setDivert(s);
        return ret;
    }

    private RunOnGson readRunOn(JsonReader jsonReader) throws IOException{
        RunOnGson ret = new RunOnGson();

        boolean b = jsonReader.nextBoolean();
        ret.setRunOn(b);
        return ret;

    }


    @Override
    public void write(JsonWriter jsonWriter, Stitch o) throws IOException {

        //not needed

    }

}
