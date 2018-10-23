/*
 * Copyright 2018 the original author or authors.
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
package org.springframework.hateoas.client;

import org.springframework.http.HttpHeaders;

/**
 * Utility to build up a set of {@link HttpHeaders}.
 * 
 * @author Greg Turnquist
 */
public final class HeaderUtils {

	public static HeaderBuilder header(String name, String value) {
		return new HeaderBuilder(name, value);
	}

	public static class HeaderBuilder {

		private final HttpHeaders headers;

		HeaderBuilder(String name, String value) {

			this.headers = new HttpHeaders();
			this.headers.add(name, value);
		}

		public HeaderBuilder header(String name, String value) {

			this.headers.add(name, value);
			return this;
		}

		public HttpHeaders build() {
			return this.headers;
		}
	}

	public static HttpHeaders mergeHeaders(HttpHeaders headersA, HttpHeaders headersB) {

		HttpHeaders mergedHeaders = new HttpHeaders();

		mergedHeaders.addAll(headersA);
		mergedHeaders.addAll(headersB);

		return mergedHeaders;
	}
}
