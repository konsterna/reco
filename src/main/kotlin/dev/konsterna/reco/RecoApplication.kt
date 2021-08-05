package dev.konsterna.reco

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RecoApplication

fun main(args: Array<String>) {
	runApplication<RecoApplication>(*args)
}
