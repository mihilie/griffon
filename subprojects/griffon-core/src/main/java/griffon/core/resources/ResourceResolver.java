/*
 * Copyright 2008-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package griffon.core.resources;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Interface for resolving resources, with support for the parameterization and internationalization of such resources.
 *
 * @author Andres Almiray
 * @author Alexander Klein
 * @since 2.0.0
 */
public interface ResourceResolver {
    /**
     * "@["
     */
    String REF_KEY_START = "@[";

    /**
     * "]"
     */
    String REF_KEY_END = "]";

    /**
     * Try to resolve the resource.
     *
     * @param key Key to lookup, such as 'sample.SampleModel.icon'
     * @return The resolved resource at the given key for the default locale
     * @throws NoSuchResourceException if no resource is found
     */
    @Nonnull
    Object resolveResource(@Nonnull String key) throws NoSuchResourceException;

    /**
     * Try to resolve the resource.
     *
     * @param key    Key to lookup, such as 'sample.SampleModel.icon'
     * @param locale Locale in which to lookup
     * @return The resolved resource at the given key for the given locale
     * @throws NoSuchResourceException if no resource is found
     */
    @Nonnull
    Object resolveResource(@Nonnull String key, @Nonnull Locale locale) throws NoSuchResourceException;

    /**
     * Try to resolve the resource.
     *
     * @param key  Key to lookup, such as 'sample.SampleModel.icon'
     * @param args Arguments that will be filled in for params within the resource (params look like "{0}" within a
     *             resource, but this might differ between implementations), or null if none.
     * @return The resolved resource at the given key for the default locale
     * @throws NoSuchResourceException if no resource is found
     */
    @Nonnull
    Object resolveResource(@Nonnull String key, @Nonnull Object[] args) throws NoSuchResourceException;

    /**
     * Try to resolve the resource.
     *
     * @param key    Key to lookup, such as 'sample.SampleModel.icon'
     * @param args   Arguments that will be filled in for params within the resource (params look like "{0}" within a
     *               resource, but this might differ between implementations), or null if none.
     * @param locale Locale in which to lookup
     * @return The resolved resource at the given key for the given locale
     * @throws NoSuchResourceException if no resource is found
     */
    @Nonnull
    Object resolveResource(@Nonnull String key, @Nonnull Object[] args, @Nonnull Locale locale) throws NoSuchResourceException;

    /**
     * Try to resolve the resource.
     *
     * @param key  Key to lookup, such as 'sample.SampleModel.icon'
     * @param args Arguments that will be filled in for params within the resource (params look like "{0}" within a
     *             resource, but this might differ between implementations), or null if none.
     * @return The resolved resource at the given key for the default locale
     * @throws NoSuchResourceException if no resource is found
     */
    @Nonnull
    Object resolveResource(@Nonnull String key, @Nonnull List<?> args) throws NoSuchResourceException;

    /**
     * Try to resolve the resource.
     *
     * @param key    Key to lookup, such as 'sample.SampleModel.icon'
     * @param args   Arguments that will be filled in for params within the resource (params look like "{0}" within a
     *               resource, but this might differ between implementations), or null if none.
     * @param locale Locale in which to lookup
     * @return The resolved resource at the given key for the given locale
     * @throws NoSuchResourceException if no resource is found
     */
    @Nonnull
    Object resolveResource(@Nonnull String key, @Nonnull List<?> args, @Nonnull Locale locale) throws NoSuchResourceException;

    /**
     * Try to resolve the resource. Return default resource if no resource was found.
     *
     * @param key          Key to lookup, such as 'sample.SampleModel.icon'
     * @param defaultValue Message to return if the lookup fails
     * @return The resolved resource at the given key for the default locale
     */
    @Nullable
    Object resolveResource(@Nonnull String key, @Nullable Object defaultValue);

    /**
     * Try to resolve the resource. Return default resource if no resource was found.
     *
     * @param key          Key to lookup, such as 'sample.SampleModel.icon'
     * @param locale       Locale in which to lookup
     * @param defaultValue Message to return if the lookup fails
     * @return The resolved resource at the given key for the given locale
     */
    @Nullable
    Object resolveResource(@Nonnull String key, @Nonnull Locale locale, @Nullable Object defaultValue);

    /**
     * Try to resolve the resource. Return default resource if no resource was found.
     *
     * @param key          Key to lookup, such as 'sample.SampleModel.icon'
     * @param args         Arguments that will be filled in for params within the resource (params look like "{0}"
     *                     within a resource, but this might differ between implementations), or null if none.
     * @param defaultValue Message to return if the lookup fails
     * @return The resolved resource at the given key for the default locale
     */
    @Nullable
    Object resolveResource(@Nonnull String key, @Nonnull Object[] args, @Nullable Object defaultValue);

    /**
     * Try to resolve the resource. Return default resource if no resource was found.
     *
     * @param key          Key to lookup, such as 'sample.SampleModel.icon'
     * @param args         Arguments that will be filled in for params within the resource (params look like "{0}"
     *                     within a resource, but this might differ between implementations), or null if none.
     * @param locale       Locale in which to lookup
     * @param defaultValue Message to return if the lookup fails
     * @return The resolved resource at the given key for the given locale
     */
    @Nullable
    Object resolveResource(@Nonnull String key, @Nonnull Object[] args, @Nonnull Locale locale, @Nullable Object defaultValue);

    /**
     * Try to resolve the resource. Return default resource if no resource was found.
     *
     * @param key          Key to lookup, such as 'sample.SampleModel.icon'
     * @param args         Arguments that will be filled in for params within the resource (params look like "{0}"
     *                     within a resource, but this might differ between implementations), or null if none.
     * @param defaultValue Message to return if the lookup fails
     * @return The resolved resource at the given key for the default locale
     */
    @Nullable
    Object resolveResource(@Nonnull String key, @Nonnull List<?> args, @Nullable Object defaultValue);

    /**
     * Try to resolve the resource. Return default resource if no resource was found.
     *
     * @param key          Key to lookup, such as 'sample.SampleModel.icon'
     * @param args         Arguments that will be filled in for params within the resource (params look like "{0}"
     *                     within a resource, but this might differ between implementations), or null if none.
     * @param locale       Locale in which to lookup
     * @param defaultValue Message to return if the lookup fails
     * @return The resolved resource at the given key for the given locale
     */
    @Nullable
    Object resolveResource(@Nonnull String key, @Nonnull List<?> args, @Nonnull Locale locale, @Nullable Object defaultValue);

    /**
     * Try to resolve the resource.
     *
     * @param key  Key to lookup, such as 'sample.SampleModel.icon'
     * @param args Arguments that will be filled in for params within the resource (params look like "{:key}"
     *             within a resource, but this might differ between implementations), or null if none.
     * @return The resolved resource at the given key for the default locale
     * @throws NoSuchResourceException if no resource is found
     */
    @Nonnull
    Object resolveResource(@Nonnull String key, @Nonnull Map<String, Object> args) throws NoSuchResourceException;

    /**
     * Try to resolve the resource.
     *
     * @param key    Key to lookup, such as 'sample.SampleModel.icon'
     * @param args   Arguments that will be filled in for params within the resource (params look like "{:key}"
     *               within a resource, but this might differ between implementations), or null if none.
     * @param locale Locale in which to lookup
     * @return The resolved resource at the given key for the given locale
     * @throws NoSuchResourceException if no resource is found
     */
    @Nonnull
    Object resolveResource(@Nonnull String key, @Nonnull Map<String, Object> args, @Nonnull Locale locale) throws NoSuchResourceException;

    /**
     * Try to resolve the resource. Return default resource if no resource was found.
     *
     * @param key          Key to lookup, such as 'sample.SampleModel.icon'
     * @param args         Arguments that will be filled in for params within the resource (params look like "{:key}"
     *                     within a resource, but this might differ between implementations), or null if none.
     * @param defaultValue Message to return if the lookup fails
     * @return The resolved resource at the given key for the default locale
     */
    @Nullable
    Object resolveResource(@Nonnull String key, @Nonnull Map<String, Object> args, @Nullable Object defaultValue);

    /**
     * Try to resolve the resource. Return default resource if no resource was found.
     *
     * @param key          Key to lookup, such as 'sample.SampleModel.icon'
     * @param args         Arguments that will be filled in for params within the resource (params look like "{:key}"
     *                     within a resource, but this might differ between implementations), or null if none.
     * @param locale       Locale in which to lookup
     * @param defaultValue Message to return if the lookup fails
     * @return The resolved resource at the given key for the given locale
     */
    @Nullable
    Object resolveResource(@Nonnull String key, @Nonnull Map<String, Object> args, @Nonnull Locale locale, @Nullable Object defaultValue);

    /**
     * <p>Resolve a resource given a key and a Locale.</p>
     * <p>
     * This method should use the default Locale if the locale argument is null. The {@code key} argument may refer to
     * another key if the resolved value results in a {@code CharSequence} that begins with "@[" and ends with "]". In this
     * case the method will use the enclosed value as the next key to be resolved. For example, given the following key/value
     * definitions
     * <p/>
     * <pre>
     *     some.key = Hello {0}
     *     other.key = @[some.key]
     * </pre>
     * <p/>
     * Evaluating the keys results in
     * <p/>
     * <pre>
     *    assert resolveResourceValue('some.key', Locale.default) == 'Hello {0}'
     *    assert resolveResourceValue('other.key', Locale.default) == 'Hello {0}'
     * </pre>
     * <p/>
     * </p>
     *
     * @param key    Key to lookup, such as 'sample.SampleModel.icon'
     * @param locale Locale in which to lookup
     * @return the resolved resource value at the given key for the given locale
     * @throws NoSuchResourceException if no message is found
     */
    @Nonnull
    Object resolveResourceValue(@Nonnull String key, @Nonnull Locale locale) throws NoSuchResourceException;

    /**
     * Formats the given resource using supplied args to substitute placeholders.
     *
     * @param resource The resource following a predefined format.
     * @param args     Arguments that will be filled in for params within the resource (params look like "{0}"
     *                 within a resource, but this might differ between implementations), or null if none.
     * @return the formatted resource with all matching placeholders with their substituted values.
     */
    @Nonnull
    String formatResource(@Nonnull String resource, @Nonnull List<?> args);

    /**
     * Formats the given resource using supplied args to substitute placeholders.
     *
     * @param resource The resource following a predefined format.
     * @param args     Arguments that will be filled in for params within the resource (params look like "{0}"
     *                 within a resource, but this might differ between implementations), or null if none.
     * @return the formatted resource with all matching placeholders with their substituted values.
     */
    @Nonnull
    String formatResource(@Nonnull String resource, @Nonnull Object[] args);

    /**
     * Formats the given resource using supplied args to substitute placeholders.
     *
     * @param resource The resource following a predefined format.
     * @param args     Arguments that will be filled in for params within the resource (params look like "{:key}"
     *                 within a resource, but this might differ between implementations), or null if none.
     * @return the formatted resource with all matching placeholders with their substituted values.
     */
    @Nonnull
    String formatResource(@Nonnull String resource, @Nonnull Map<String, Object> args);
}
