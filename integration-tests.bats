#!/usr/bin/env bats

@test "should give the correct output for the given input" {
  result="$(java -jar target/blackjack-1.0-SNAPSHOT.jar <(echo 'CA, D5, H9, HQ, S8'))"
  expected=$'sam\nsam: CA, H9\ndealer: D5, HQ, S8'
  [ "$result" = "$expected" ]
}

@test "should return successfully when not given any arguments" {
  java -jar target/blackjack-1.0-SNAPSHOT.jar
  [ $? -eq 0 ]
}

@test "should return unsuccessfully when given a non-exsistent file" {
  run java -jar target/blackjack-1.0-SNAPSHOT.jar /nonexistentfile
  [ "$status" -ge 1 ]
}
