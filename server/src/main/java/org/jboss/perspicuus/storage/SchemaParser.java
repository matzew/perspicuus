/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.perspicuus.storage;

import java.util.List;
import java.util.Optional;

/**
 * Integration point for Schema type-specific parsing libraries.
 *
 * @since 2018-02
 * @author Jonathan Halliday (jonathan.halliday@redhat.com)
 */
public interface SchemaParser {

    /**
     * Given an input String, validate that it can be parsed to a valid Schema of some type
     * and if so, return a normalized String representation thereof. If not, return empty.
     *
     * @param rawSchema
     * @return
     */
    Optional<String> parseToCanonicalForm(String rawSchema);

    /**
     * Given a valid Schema of appropriate format, extract a list of the tokens to be used
     * for full-text search indexing e.g. the field names.
     *
     * @param schema
     * @return
     */
    List<String> tokenizeForSearch(String schema);

    /**
     * Determine the compatibility of two schema, according to appropriate type specific rules.
     *
     * @param compatibilityLevel
     * @param existingSchema
     * @param proposedSchema
     * @return
     */
    boolean isCompatibleWith(String compatibilityLevel, String existingSchema, String proposedSchema);
}
