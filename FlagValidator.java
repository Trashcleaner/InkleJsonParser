
import gson_objects.FlagName;
import model.Stitch;

import java.util.HashMap;
import java.util.List;

/**
 * Helper class for Control.
 * Responsibility is to take care of flags.
 * Class has 2 public methods. One to take care of new flags and store them in a map.
 * Another to establish is flag is passed and return a boolean.
 * <p>
 * Flags are two types. Static and Dynamic.
 * Static is without a value.
 * Dynamic is with increasing or decreasing value.
 * <p>
 * example from stitch
 * {"flagname": "sword taken"}
 * Created by obrusvit on 25.4.17.
 */

public class FlagValidator {


    static final String TAG = "FlagValidator";


    /**
     * Serves for conditional logic. Maps stores visited flags and their values.
     */
    private HashMap<String, Integer> reachedFlags;

    public FlagValidator() {
        reachedFlags = new HashMap<>();
    }


    /**
     * FIRST public method.
     * Method is called when exposed to new stitch.
     *
     * @param stitch
     */
    public void takeCareOfNewFlags(Stitch stitch) {
        if (stitch.getFlagNames().size() > 0) {
            for (FlagName flag : stitch.getFlagNames()) {
                storeThisFlagInMap(flag.getFlagName());
            }
        }
    }

    public void takeCareOfNewFlags(List<Stitch> stitchDivertList) {
        for (Stitch stitch :
                stitchDivertList) {
            takeCareOfNewFlags(stitch);
        }
    }


    private void storeThisFlagInMap(String input) {

        String flag = input.replaceAll(" ", "");

        if (isStaticFlag(flag)) {
            storeStaticFlag(flag);
        } else {
            storeDynamicFlag(flag);
        }
    }

    private boolean isStaticFlag(String flag) {
        return !(flag.contains("-") || flag.contains("+")
                || flag.contains(">") || flag.contains("<")
                || flag.contains("="));
    }

    private void storeDynamicFlag(String flag) {
        String[] parts = new String[2];
        if (flag.contains("-")) {
            parts = flag.split("-", 2);
        } else if (flag.contains("+")) {
            parts = flag.split("\\+", 2);
        }
        String name = parts[0];
        int value = Integer.parseInt(parts[1]);
        int currentValue;
        if (reachedFlags.containsKey(name)) {
            currentValue = reachedFlags.get(name);
        } else {
            currentValue = 0;
        }

        if (flag.contains("-")) {
            currentValue -= value;
        } else {
            currentValue += value;
        }
        reachedFlags.put(name, currentValue);
    }

    private void storeStaticFlag(String flag) {
        if (!isFlagReached(flag)) {
            reachedFlags.put(flag, Integer.MIN_VALUE);
        }
    }


    /**flagName
     * SECOND public method
     * Can we go to this Stitch/Option?
     *
     * @param input
     * @return
     */
    public boolean isFlagValid(String input) {
        String flag = input.replaceAll(" ", "");
        if (isStaticFlag(flag)) {
            return isFlagReached(flag);
        } else if (flag.contains(">=")) {
            return decideFlagValidity(flag, ">=");
        } else if (flag.contains("<=")) {
            return decideFlagValidity(flag, "<=");
        } else if (flag.contains(">")) {
            return decideFlagValidity(flag, ">");
        } else if (flag.contains("<")) {
            return decideFlagValidity(flag, "<");
        } else if (flag.contains("=")) {
            return decideFlagValidity(flag, "=");
        }else{
            return false;
        }


    }

    private boolean decideFlagValidity(String flag, String task){
        String[] parts = flag.split(task, 2);
        String name = parts[0];
        if (!reachedFlags.containsKey(name)) {
            return false;
        }
        int value = Integer.parseInt(parts[1]);
        int currentValue = reachedFlags.get(name);
        switch (task){
            case ">=":
                return currentValue >= value;
            case "<=":
                return currentValue <= value;
            case ">":
                return currentValue > value;
            case "<":
                return currentValue < value;
            case "=":
                return currentValue == value;
            default:
                return false;
        }
    }


    private boolean isFlagReached(String flag) {
        return reachedFlags.containsKey(flag);
    }


    /**
     * THIRD public method.
     */
    public int getValueOfFlagOrZero(String flag){
        if(!isFlagReached(flag)){
            return 0;
        }else{
            int toRet = reachedFlags.get(flag);
            if(toRet == Integer.MIN_VALUE){
                return 1;
            }else{
                return reachedFlags.get(flag);
            }
        }
    }


}
