package constraints.npe

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.inject.Inject
import javax.validation.ConstraintViolationException

@MicronautTest
class FooEntityServiceConstraintsSpec extends Specification {

    @Inject
    FooService fooService

    @Unroll
    void 'test "methodWithString(#param)" triggers ConstraintViolationException'() {
        when:
        fooService.methodWithString(param)

        then:
        def e = thrown(ConstraintViolationException)
        e.constraintViolations.collect { it.propertyPath.toString() }.any { it.contains(field) }
        e.constraintViolations.collect { it.message }.any { it.contains(errorMessage) }

        where:
        param | field                    | errorMessage
        null  | 'methodWithString.param' | 'must not be blank'
        ''    | 'methodWithString.param' | 'must not be blank'
    }

}
