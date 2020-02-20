package org.dojo.trafficlights;

import org.assertj.core.api.Assertions;
import org.dojo.trafficlights.Dinglemouse;
import org.junit.jupiter.api.Test;

class DinglemouseTest {


    @Test
    void givenCarFarFromTrafficLight_whenOneTimeUnitPassed_thenCarOneStepFurther() {
        String givenRoad =
                "C...R............G......";  // 0

        String[] actualRoads = Dinglemouse.trafficLights(givenRoad, 1);
        String expectedRoad = ".C..R............G......";
        Assertions.assertThat(actualRoads).containsExactly(givenRoad, expectedRoad);
    }


    @Test
    void givenCarInFrontOfRedTrafficLight_whenOneTimeUnitPassed_thenStillInfrontOfRedTrafficLight() {
        String givenRoad =
                "....CR............G......";  // 0

        String[] actualRoads = Dinglemouse.trafficLights(givenRoad, 1);
        String expectedRoad = "....CR............G......";  // 0
        Assertions.assertThat(actualRoads).containsExactly(givenRoad, expectedRoad);
    }


    @Test
    void givenCarInFrontOfOrangeTrafficLight_whenOneTimeUnitPassed_thenStillInfrontOfRedTrafficLight() {
        String givenRoad =
                "....CO............G......";  // 0

        String[] actualRoads = Dinglemouse.trafficLights(givenRoad, 1);
        String expectedRoad = "....CO............G......";  // 0
        Assertions.assertThat(actualRoads).containsExactly(givenRoad, expectedRoad);
    }
    @Test
    void givenCarInFrontOfGreenTrafficLight_whenOneTimeUnitPassed_thenCarIsAtIntersection() {
        String givenRoad =
                "....CG............G......";  // 0

        String[] actualRoads = Dinglemouse.trafficLights(givenRoad, 1);
        String expectedRoad = ".....C............G......";  // 0
        Assertions.assertThat(actualRoads).containsExactly(givenRoad, expectedRoad);
    }

    @Test
    void givenCarInFrontOfGreenTrafficLight_whenTwoTimeUnitPassed_thenCarHasCrossedIntersection() {
        String givenRoad =
                "....CG............G......";  // 0

        String[] actualRoads = Dinglemouse.trafficLights(givenRoad, 2);
        String expectedRoadAfterFirstStep = ".....C............G......";  // 0
        String expectedRoadAfterSecondStep = ".....GC...........G......";  // 0
        Assertions.assertThat(actualRoads).containsExactly(givenRoad, expectedRoadAfterFirstStep, expectedRoadAfterSecondStep);
    }

    @Test
    void givenCarFarFromTrafficLight_whenFiveTimeUnitPassed_thenTrafficLightCycled() {
        String givenRoad =
                "C........R............G......";

        String[] actualRoads = Dinglemouse.trafficLights(givenRoad, 5);
        String expectedRoadAfterFirstStep = ".C.......R............G......";
        String expectedRoadAfterSecondStep = "..C......R............G......";
        String expectedRoadAfterThirdStep = "...C.....R............G......";
        String expectedRoadAfterFourthStep = "....C....R............G......";
        String expectedRoadAfterFifthStep = ".....C...G............O......";
        Assertions.assertThat(actualRoads).containsExactly(givenRoad, expectedRoadAfterFirstStep, expectedRoadAfterSecondStep, expectedRoadAfterThirdStep, expectedRoadAfterFourthStep, expectedRoadAfterFifthStep);
    }

    @Test
    void givenCarAtTheEndOfTheRoadInfrontOfTrafficLight_whenThreeTimeUnitPassed_thenCarIsOffTheRoad() {
        String givenRoad =
                ".........R............G.....CG";

        String[] actualRoads = Dinglemouse.trafficLights(givenRoad, 3);
        String expectedRoadAfterFirstStep = ".........R............G......C";
        String expectedRoadAfterSecondStep = ".........R............G......G";
        String expectedRoadAfterThirdStep = ".........R............G......G";
        Assertions.assertThat(actualRoads).containsExactly(givenRoad, expectedRoadAfterFirstStep, expectedRoadAfterSecondStep, expectedRoadAfterThirdStep);
    }

    @Test
    void greenTrafficLightAfter5StepsIsOrange(){
        char actualTrafficLight = Dinglemouse.greenTrafficLightAfter(5);
        Assertions.assertThat(actualTrafficLight).isEqualTo('O');
    }

    @Test
    void greenTrafficLightAfter11StepsIsGreen(){
        char actualTrafficLight = Dinglemouse.greenTrafficLightAfter(11);
        Assertions.assertThat(actualTrafficLight).isEqualTo('R');
    }
    @Test
    void greenTrafficLightAfter7StepsIsRed(){
        char actualTrafficLight = Dinglemouse.greenTrafficLightAfter(7);
        Assertions.assertThat(actualTrafficLight).isEqualTo('R');
    }

    @Test
    void redTrafficLightAfter11StepsIsRed(){
        char actualTrafficLight = Dinglemouse.redTrafficLightAfter(0);
        Assertions.assertThat(actualTrafficLight).isEqualTo('R');
    }
    @Test
    void redTrafficLightAfter5StepsIsGreen(){
        char actualTrafficLight = Dinglemouse.redTrafficLightAfter(5);
        Assertions.assertThat(actualTrafficLight).isEqualTo('G');
    }

    @Test
    void redTrafficLightAfter10StepsIsOrange(){
        char actualTrafficLight = Dinglemouse.redTrafficLightAfter(10);
        Assertions.assertThat(actualTrafficLight).isEqualTo('O');
    }




}
