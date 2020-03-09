package com.company.java8.optionals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        final List<String> NAMES = Arrays.asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh", "Yogen", "Prateema");
        System.out.println(luckyName(NAMES, "An"));
        pickLuckyNameNewWay(NAMES, "Ni");
        postMessage(pickLuckyNameWOrElse(NAMES, "Gi"));
    }

    private static String luckyName(final List<String> names, final String startWithName) {
        Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startWithName)).findFirst();
        return luckyName.orElse("No Name Found in the lucky drop");
    }

    public static void pickLuckyNameNewWay(final List<String> names, final String startingLetter) {
        final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
        luckyName.ifPresent(OptionalExample::postMessage);
    }

    public static String pickLuckyNameWOrElse(final List<String> names, final String startingLetter) {
        final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
        return luckyName.orElseThrow(() -> new NotFoundException("There is no name starting with letter."));
    }

    public static void postMessage(final String winnerName) {
        System.out.println(String.format("Congratulations, %s!", winnerName));
    }

    private static class NotFoundException extends RuntimeException {
        public NotFoundException(String s) {
            super(s);
        }
    }
}
