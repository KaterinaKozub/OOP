package ua.opnu;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MainTest {

    public static Main main;

    @BeforeAll
    static void setup() {
        main = new Main();
    }

    // IcyHot
    @ParameterizedTest
    @MethodSource("icyHotProvider")
    public void icyHot(int first, int second, boolean expected) {
        assertEquals(expected, main.icyHot(first, second));
    }

    static Stream<Arguments> icyHotProvider() {
        return Stream.of(
                arguments(120, -1, true),
                arguments(-1, 120, true),
                arguments(2, 120, false),
                arguments(-1, 100, false),
                arguments(-2, -2, false),
                arguments(120, 120, false));
    }

    // in1020
    @ParameterizedTest
    @MethodSource("in1020Provider")
    public void in1020(int first, int second, boolean expected) {
        assertEquals(expected, main.in1020(first, second));
    }

    static Stream<Arguments> in1020Provider() {
        return Stream.of(
                arguments(12, 99, true),
                arguments(21, 12, true),
                arguments(8, 99, false),
                arguments(99, 10, true),
                arguments(20, 20, true),
                arguments(21, 21, false),
                arguments(9, 9, false));
    }

    // hasTeen
    @ParameterizedTest
    @MethodSource("hasTeenProvider")
    public void hasTeen(int first, int second, int third, boolean expected) {
        assertEquals(expected, main.hasTeen(first, second, third));
    }

    static Stream<Arguments> hasTeenProvider() {
        return Stream.of(
                arguments(13, 20, 10, true),
                arguments(20, 19, 10, true),
                arguments(20, 10, 13, true),
                arguments(1, 20, 12, false),
                arguments(19, 20, 12, true),
                arguments(12, 20, 19, true),
                arguments(12, 9, 20, false),
                arguments(12, 18, 20, true),
                arguments(14, 2, 20, true),
                arguments(4, 2, 20, false),
                arguments(11, 22, 22, false));
    }

    // sleepIn
    @ParameterizedTest
    @MethodSource("sleepInProvider")
    public void sleepIn(boolean first, boolean second, boolean expected) {
        assertEquals(expected, main.sleepIn(first, second));
    }

    static Stream<Arguments> sleepInProvider() {
        return Stream.of(
                arguments(false, false, true),
                arguments(true, false, false),
                arguments(false, true, true),
                arguments(true, true, true));
    }

    // monkeyTrouble
    @ParameterizedTest
    @MethodSource("monkeyTroubleProvider")
    public void monkeyTrouble(boolean first, boolean second, boolean expected) {
        assertEquals(expected, main.monkeyTrouble(first, second));
    }

    static Stream<Arguments> monkeyTroubleProvider() {
        return Stream.of(
                arguments(true, true, true),
                arguments(false, false, true),
                arguments(true, false, false),
                arguments(false, true, false));
    }

    // posNeg
    @ParameterizedTest
    @MethodSource("posNegProvider")
    public void posNeg(int first, int second, boolean third, boolean expected) {
        assertEquals(expected, main.posNeg(first, second, third));
    }

    static Stream<Arguments> posNegProvider() {
        return Stream.of(
                arguments(1, -1, false, true),
                arguments(-1, 1, false, true),
                arguments(-4, -5, true, true),
                arguments(-4, -5, false, false),
                arguments(-4, 5, false, true),
                arguments(-4, 5, true, false),
                arguments(1, 1, false, false),
                arguments(-1, -1, false, false),
                arguments(1, -1, true, false),
                arguments(-1, 1, true, false),
                arguments(1, 1, true, false),
                arguments(-1, -1, true, true),
                arguments(5, -5, false, true),
                arguments(-6, 6, false, true),
                arguments(-5, -6, false, false),
                arguments(-2, -1, false, false),
                arguments(1, 2, false, false),
                arguments(-5, 6, true, false),
                arguments(-5, -5, true, true));
    }

    // arrayCount9
    @ParameterizedTest
    @MethodSource("arrayCount9Provider")
    public void arrayCount9(int[] array, int expected) {
        assertEquals(expected, main.arrayCount9(array));
    }

    static Stream<Arguments> arrayCount9Provider() {
        return Stream.of(
                arguments(new int[]{1, 2, 9}, 1),
                arguments(new int[]{1, 9, 9}, 2),
                arguments(new int[]{1, 9, 9, 3, 9}, 3),
                arguments(new int[]{1, 2, 3}, 0),
                arguments(new int[]{}, 0),
                arguments(new int[]{4, 2, 4, 3, 1}, 0),
                arguments(new int[]{9, 2, 4, 3, 1}, 1));
    }

    // arrayFront9
    @ParameterizedTest
    @MethodSource("arrayFront9Provider")
    public void arrayFront9(int[] array, boolean expected) {
        assertEquals(expected, main.arrayFront9(array));
    }

    static Stream<Arguments> arrayFront9Provider() {
        return Stream.of(
                arguments(new int[]{1, 2, 9, 3, 4}, true),
                arguments(new int[]{1, 2, 3, 4, 9}, false),
                arguments(new int[]{1, 2, 3, 4, 5}, false),
                arguments(new int[]{9, 2, 3}, true),
                arguments(new int[]{1, 9, 9}, true),
                arguments(new int[]{1, 2, 3}, false),
                arguments(new int[]{1, 9}, true),
                arguments(new int[]{5, 5}, false),
                arguments(new int[]{2}, false),
                arguments(new int[]{9}, true),
                arguments(new int[]{}, false),
                arguments(new int[]{3, 9, 2, 3, 3}, true));
    }

    // array123
    @ParameterizedTest
    @MethodSource("array123Provider")
    public void array123(int[] array, boolean expected) {
        assertEquals(expected, main.array123(array));
    }

    static Stream<Arguments> array123Provider() {
        return Stream.of(
                arguments(new int[]{1, 1, 2, 3, 1}, true),
                arguments(new int[]{1, 1, 2, 4, 1}, false),
                arguments(new int[]{1, 1, 2, 1, 2, 3}, true),
                arguments(new int[]{1, 1, 2, 1, 2, 1}, false),
                arguments(new int[]{1, 2, 3, 1, 2, 3}, true),
                arguments(new int[]{1, 2, 3}, true),
                arguments(new int[]{1, 1, 1}, false),
                arguments(new int[]{1, 2}, false),
                arguments(new int[]{1}, false),
                arguments(new int[]{}, false));
    }

    // helloName
    @ParameterizedTest
    @MethodSource("helloNameProvider")
    public void helloName(String name, String expected) {
        assertEquals(expected, main.helloName(name));
    }

    static Stream<Arguments> helloNameProvider() {
        return Stream.of(
                arguments("Bob", "Hello Bob!"),
                arguments("Alice", "Hello Alice!"),
                arguments("X", "Hello X!"),
                arguments("Dolly", "Hello Dolly!"),
                arguments("Alpha", "Hello Alpha!"),
                arguments("Omega", "Hello Omega!"),
                arguments("Goodbye", "Hello Goodbye!"),
                arguments("ho ho ho", "Hello ho ho ho!"),
                arguments("xyz!", "Hello xyz!!"),
                arguments("Hello", "Hello Hello!"));
    }

    // lastTwo
    @ParameterizedTest
    @MethodSource("lastTwoProvider")
    public void lastTwo(String str, String expected) {
        assertEquals(expected, main.lastTwo(str));
    }

    static Stream<Arguments> lastTwoProvider() {
        return Stream.of(
                arguments("coding", "codign"),
                arguments("cat", "cta"),
                arguments("ab", "ba"),
                arguments("a", "a"),
                arguments("", ""));
    }

    // middleTwo
    @ParameterizedTest
    @MethodSource("middleTwoProvider")
    public void middleTwo(String str, String expected) {
        assertEquals(expected, main.middleTwo(str));
    }

    static Stream<Arguments> middleTwoProvider() {
        return Stream.of(
                arguments("string", "ri"),
                arguments("code", "od"),
                arguments("Practice", "ct"),
                arguments("ab", "ab"),
                arguments("0123456789", "45"));
    }
}
