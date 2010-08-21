/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.file.filters;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A convenience base class for any {@link FileListFilter} whose criteria can be
 * evaluated against each File in isolation. If the entire List of files is
 * required for evaluation, implement the FileListFilter interface directly.
 *
 * @author Mark Fisher
 * @author Iwein Fuld
 */
@Deprecated
public abstract class AbstractFileListFilter implements FileListFilter {

    /**
     * {@inheritDoc}
     */
    public final List<File> filterFiles(File[] files) {
        List<File> accepted = new ArrayList<File>();
        if (files != null) {
            for (File file : files) {
                if (this.accept(file)) {
                    accepted.add(file);
                }
            }
        }
        return accepted;
    }

    /**
     * Subclasses must implement this method.
     */
    protected abstract boolean accept(File file);

}