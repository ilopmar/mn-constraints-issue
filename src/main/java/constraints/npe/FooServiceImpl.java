package constraints.npe;

import javax.annotation.Nonnull;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;

@Singleton
public class FooServiceImpl implements FooService {

    @Nonnull
    @Override
    @Transactional
    public String methodWithString(@NotBlank String param) {
        throw new RuntimeException("This should not be executed during test execution");
    }

}
