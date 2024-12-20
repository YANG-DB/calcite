/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.calcite.sql.fun;

import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlLiteral;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlOperator;
import org.apache.calcite.sql.parser.SqlParserPos;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A factory for creating {@link org.apache.calcite.sql.SqlCall}.
 */
@FunctionalInterface
public interface SqlCallFactory {

  /**
   * Creates a call to this operator with an array of operands.
   *
   * <p>The position of the resulting call is the union of the {@code pos}
   * and the positions of all of the operands.
   *
   * @param functionQualifier Function qualifier (e.g. "DISTINCT"), or null
   * @param pos               Parser position of the identifier of the call
   * @param operands          Array of operands
   */
  SqlCall create(
      SqlOperator operator,
      @Nullable SqlLiteral functionQualifier,
      SqlParserPos pos,
      @Nullable SqlNode... operands);
}
