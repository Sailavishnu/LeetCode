public static int sumDigitsInString(String s) {
    return s.chars()
            .filter(Character::isDigit)
            .map(ch -> ch - '0')
            .sum();
}
