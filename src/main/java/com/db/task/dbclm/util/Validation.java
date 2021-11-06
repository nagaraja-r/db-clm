package com.db.task.dbclm.util;

import java.util.Optional;

@FunctionalInterface
public interface Validation<K> {
    Optional<ValidationRules> validate(K param);
}
