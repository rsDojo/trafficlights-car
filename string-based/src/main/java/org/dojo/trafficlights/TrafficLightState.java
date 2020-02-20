package org.dojo.trafficlights;

public enum TrafficLightState {
    G, O, R;

    public static TrafficLightState of(char c) {
        if(c == 'R') return R;
        if(c == 'O') return O;
        if(c == 'G') return G;

        throw new IllegalArgumentException();
    }
}
