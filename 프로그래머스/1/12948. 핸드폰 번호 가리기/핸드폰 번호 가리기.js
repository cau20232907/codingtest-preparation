function solution(phone_number) {
    const phone_number_length = phone_number.length;
    return phone_number.slice(-4)
        .padStart(phone_number_length,"*");
}