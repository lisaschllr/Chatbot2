import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

public class Dictonary {
    private Config Config = new Config();
    private Data Data = new Data();

    Map<String, String> Keys = MapUtils.putAll(new HashMap<String, String>(), new String[][] {
            {"laptop", Config.LaptopProblem},
            {"macbook", Config.LaptopProblem},
            {"smartphone", Config.SmartphoneProblem},
            {"mobilephone", Config.SmartphoneProblem},
            {"handy", Config.SmartphoneProblem},
            {"chargeing", Config.ChargingProblem},
            {"charge", Config.ChargingProblem}
    });

    Map<String, String> Responses = MapUtils.putAll(new HashMap<String, String>(), new String[][] {
            //Laptop Problems
            {Config.LaptopProblem, Data.AskForLaptopProblem},
            {Config.LaptopProblem + Config.ChargingProblem, Data.LaptopNotChargingSolution1},
            {Config.LaptopProblem + Config.ChargingProblem + Config.Solution + Config.Negative, Data.LaptopNotChargingSolution2},
            {Config.LaptopProblem + Config.ChargingProblem + Config.Solution + Config.Positive, Data.SayGoodbye},
            {Config.LaptopProblem + Config.ChargingProblem + Config.Solution + Config.Negative + Config.Solution + Config.Negative, Data.NoHelp},
            {Config.LaptopProblem + Config.ChargingProblem + Config.Solution + Config.Negative + Config.Solution + Config.Positive, Data.SayGoodbye},
            //SmartphoneProblems
            {Config.SmartphoneProblem, Data.AskForSmartphoneProblem},
            {Config.SmartphoneProblem + Config.ChargingProblem, Data.SmartphoneNotChargingSolution1},
            {Config.SmartphoneProblem + Config.ChargingProblem + Config.Solution + Config.Negative, Data.SmartphoneNotChargingSolution2},
            {Config.SmartphoneProblem + Config.ChargingProblem + Config.Solution + Config.Positive, Data.SayGoodbye},
            {Config.SmartphoneProblem + Config.ChargingProblem + Config.Solution + Config.Negative + Config.Solution + Config.Negative, Data.NoHelp},
            {Config.SmartphoneProblem+ Config.ChargingProblem + Config.Solution + Config.Negative + Config.Solution + Config.Positive, Data.SayGoodbye}
    });

    String[] badKeyword = new String[] {"no", "not"};
    String[] goodKeyword = new String[] {"yes", "yeah", "great"};
    String[] End = new String[] {"bye", "goodbye", "thanks", "thank you"};

    String Greeting = "Hi, I am your support chatbot, I will try to help you with your problem with our product. Which of our products is it?";

}
