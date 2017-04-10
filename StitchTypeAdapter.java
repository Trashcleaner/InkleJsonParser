import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
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
        ArrayList<Option> options = new ArrayList<>(5);
        IfCondition ifCondition = null;
        NotIfCondition notIfCondition = null;
        Divert divertName = null;
        FlagName flagName = null;
        PageLabel pageLabel = null;
        PageNum pageNum = null;
        RunOn runOn = null;

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
                jsonReader.beginObject(); //object in array
                while(jsonReader.hasNext()){
                    if(jsonReader.peek().equals(JsonToken.NAME)) {
                        String var = jsonReader.nextName();
                        switch (var){
                            case "ifConditions":
                            case "notIfConditions":
                            case "option":
                            case "linkPath":
                                System.out.println("Consuming Option");
                                Option option= readOption(jsonReader, var);
                                options.add(option);
                                break;
                            case "divert":
                                System.out.println("Consuming divert");
                                divertName = readDivert(jsonReader);
                                break;
                            case "ifCondition":
                                System.out.println("Consuming if condition");
                                ifCondition = readIfCondition(jsonReader);
                                break;
                            case "notIfCondition":
                                System.out.println("Consuming if condition");
                                notIfCondition = readNotIfCondition(jsonReader);
                                break;

                            case "flagName":
                                System.out.println("Consuming FlagName");
                                flagName = readFlagName(jsonReader);
                                break;

                            case "pageNum":
                                System.out.println("Consuming PageNum");
                                pageNum = readPageNum(jsonReader);
                                break;
                            case "pageLabel":
                                System.out.println("Consuming PageLabel");
                                pageLabel = readPageLabel(jsonReader);
                                break;
                            case "runOn":
                                System.out.println("Consuming runOn");
                                runOn = readRunOn(jsonReader);
                            default:
                                jsonReader.skipValue();
                                break;
                        }

                    }
                    ///jsonReader.skipValue(); //toto pujde prych po implementaci read* methods
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


    private Option readOption(JsonReader jsonReader, String var) throws IOException{

        Option ret = new Option();
        ArrayList<IfCondition> ifConditions = new ArrayList<>();
        ArrayList<NotIfCondition> notIfConditions  = new ArrayList<>();

        boolean end;
        do {

            switch (var) {
                case "ifConditions":
                    if(jsonReader.peek().equals(JsonToken.BEGIN_ARRAY)) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            if (jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)) {
                                jsonReader.beginObject(); //object in array
                                while (jsonReader.hasNext()) {
                                    jsonReader.nextName();
                                    IfCondition ifCondition = readIfCondition(jsonReader);
                                    ifConditions.add(ifCondition);
                                }
                                jsonReader.endObject();
                            }
                        }
                        jsonReader.endArray();
                    }else{
                        jsonReader.nextNull();
                    }
                    break;
                case "notIfConditions":
                    if(jsonReader.peek().equals(JsonToken.BEGIN_ARRAY)) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            if (jsonReader.peek().equals(JsonToken.BEGIN_OBJECT)) {
                                jsonReader.beginObject(); //object in array
                                while (jsonReader.hasNext()) {
                                    jsonReader.nextName();
                                    NotIfCondition notIfCondition = readNotIfCondition(jsonReader);
                                    notIfConditions.add(notIfCondition);
                                }
                                jsonReader.endObject();
                            }
                        }
                        jsonReader.endArray();
                    }else{
                        jsonReader.nextNull();
                    }
                    break;
                case "option":
                    ret.setOption(jsonReader.nextString());
                    break;
                case "linkPath":
                    ret.setLinkPath(jsonReader.nextString());
                    break;
            }

            end = jsonReader.peek().equals(JsonToken.END_OBJECT);
            if(!end) var = jsonReader.nextName();

        }while(!end);

        ret.setIfConditions(ifConditions);
        ret.setNotIfConditions(notIfConditions);

        return ret;
    }


    private IfCondition readIfCondition(JsonReader jsonReader) throws IOException{
        IfCondition ret = new IfCondition();
        ret.setIfCondition(jsonReader.nextString());
        return ret;
    }

    private NotIfCondition readNotIfCondition(JsonReader jsonReader) throws IOException{
        NotIfCondition ret = new NotIfCondition();
        ret.setNotIfCondition(jsonReader.nextString());
        return ret;
    }


    private Divert readDivert(JsonReader jsonReader) throws IOException {
        Divert ret = new Divert();
        String s = jsonReader.nextString();
        ret.setDivert(s);
        return ret;
    }



    private FlagName readFlagName(JsonReader jsonReader) throws IOException{
        FlagName ret = new FlagName();
        ret.setFlagName(jsonReader.nextString());
        return ret;

    }

    private PageNum readPageNum(JsonReader jsonReader) throws IOException{
        PageNum ret = new PageNum();
        ret.setPageNum(jsonReader.nextInt());
        return ret;
    }

    private PageLabel readPageLabel(JsonReader jsonReader) throws IOException{
        PageLabel ret = new PageLabel();
        ret.setPageLabel(jsonReader.nextString());
        return ret;
    }


    private RunOn readRunOn(JsonReader jsonReader) throws IOException{
        RunOn ret = new RunOn();
        ret.setRunOn(jsonReader.nextBoolean());
        return ret;

    }


    @Override
    public void write(JsonWriter jsonWriter, Stitch o) throws IOException {

        //not needed

    }

}
