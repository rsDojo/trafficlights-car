package org.dojo.trafficlights;

public class Dinglemouse {

    public static String[] trafficLights(String road, int n) {
        String[] result = new String[n + 1];

        char[] initialRoad = road.toCharArray();
        result[0] = road;

        for (int i = 1; i <= n; i++) {

            int indexOf = road.indexOf("C");
            char[] chars = road.toCharArray();

            updateTrafficLights(initialRoad, i, chars);
            moveCar(indexOf, chars);

            String updatedRoad = new String(chars);
            result[i] = updatedRoad;
            road = updatedRoad;
        }

        return result;
    }

    private static void moveCar(int indexOf, char[] chars) {

        if (indexOf == -1) {
            return;
        }

        int carsNextPosition = indexOf + 1;

        if (carsNextPosition == chars.length) {
            if (chars[indexOf] == 'C') {
                chars[indexOf] = '.';
            }
            return;
        }

        if (carCanEnterPosition(chars[carsNextPosition])) {
            if (chars[indexOf] == 'C') {
                chars[indexOf] = '.';
            }
            chars[indexOf + 1] = 'C';
        }
    }

    private static void updateTrafficLights(char[] initialRoad, int i, char[] chars) {
        for (int o = 0; o < chars.length; o++) {
            int timeInCycle = i % 11;

            if (initialRoad[o] == 'G') {
                chars[o] = greenTrafficLightAfter(timeInCycle);
            }
            if (initialRoad[o] == 'R') {
                chars[o] = redTrafficLightAfter(timeInCycle);
            }
        }
    }

    static char redTrafficLightAfter(int timeInCycle) {
        char trafficLight;
        if (timeInCycle < 5) {
            trafficLight = 'R';

        } else if (timeInCycle == 10) {
            trafficLight = 'O';
        } else {
            trafficLight = 'G';
        }
        return trafficLight;
    }

    static char greenTrafficLightAfter(int timeInCycle) {
        char trafficLight;
        if (timeInCycle < 5) {
            trafficLight = 'G';
        } else if (timeInCycle == 5) {
            trafficLight = 'O';
        } else {
            trafficLight = 'R';
        }
        return trafficLight;
    }

    private static boolean carCanEnterPosition(char aChar) {
        return aChar != 'R' && aChar != 'O';
    }

}
