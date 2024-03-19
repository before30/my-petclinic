package cc.before30.petclinic.visits.model

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeOne
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.RepeatedTest
import java.time.LocalDate

class VisitEntityTest {

    @RepeatedTest(100)
    fun visitEntityMonkey() {
        val fixtureMonkey = FixtureMonkey.builder()
            .plugin(JakartaValidationPlugin())
            .plugin(KotlinPlugin())
            .build()

        val visit: VisitEntity = fixtureMonkey.giveMeOne()

        then(visit.date).isBeforeOrEqualTo(LocalDate.now())
        then(visit.description).isNotBlank()
    }
}
