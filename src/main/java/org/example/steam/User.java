package org.example.steam;

import java.util.List;

public record User(String name, int age, Sex sex, List<Contract> contracts) {
}
