/*
 * Copyright (c) 2002-2018 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
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
package org.neo4j.driver.internal.types;

import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Type;
import org.neo4j.driver.v1.types.TypeSystem;

import static org.neo4j.driver.internal.types.TypeConstructor.ANY_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.BOOLEAN_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.BYTES_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.DATE_TIME_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.DATE_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.DURATION_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.FLOAT_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.INTEGER_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.LIST_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.LOCAL_DATE_TIME_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.LOCAL_TIME_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.MAP_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.NODE_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.NULL_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.NUMBER_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.PATH_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.POINT_2D_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.POINT_3D_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.RELATIONSHIP_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.STRING_TyCon;
import static org.neo4j.driver.internal.types.TypeConstructor.TIME_TyCon;

/**
 * Utility class for determining and working with the Cypher types of values
 *
 * @see Value
 * @see Type
 */
public class InternalTypeSystem implements TypeSystem
{
    public static InternalTypeSystem TYPE_SYSTEM = new InternalTypeSystem();

    private final TypeRepresentation anyType = constructType( ANY_TyCon );
    private final TypeRepresentation booleanType = constructType( BOOLEAN_TyCon );
    private final TypeRepresentation bytesType = constructType( BYTES_TyCon );
    private final TypeRepresentation stringType = constructType( STRING_TyCon );
    private final TypeRepresentation numberType = constructType( NUMBER_TyCon );
    private final TypeRepresentation integerType = constructType( INTEGER_TyCon );
    private final TypeRepresentation floatType = constructType( FLOAT_TyCon );
    private final TypeRepresentation listType = constructType( LIST_TyCon );
    private final TypeRepresentation mapType = constructType( MAP_TyCon );
    private final TypeRepresentation nodeType = constructType( NODE_TyCon );
    private final TypeRepresentation relationshipType = constructType( RELATIONSHIP_TyCon );
    private final TypeRepresentation pathType = constructType( PATH_TyCon );
    private final TypeRepresentation point2dType = constructType( POINT_2D_TyCon );
    private final TypeRepresentation point3dType = constructType( POINT_3D_TyCon );
    private final TypeRepresentation dateType = constructType( DATE_TyCon );
    private final TypeRepresentation timeType = constructType( TIME_TyCon );
    private final TypeRepresentation localTimeType = constructType( LOCAL_TIME_TyCon );
    private final TypeRepresentation localDateTimeType = constructType( LOCAL_DATE_TIME_TyCon );
    private final TypeRepresentation dateTimeType = constructType( DATE_TIME_TyCon );
    private final TypeRepresentation durationType = constructType( DURATION_TyCon );
    private final TypeRepresentation nullType = constructType( NULL_TyCon );

    private InternalTypeSystem()
    {
    }

    /** the Cypher type ANY */
    @Override
    public Type ANY()
    {
        return anyType;
    }

    /** the Cypher type BOOLEAN */
    @Override
    public Type BOOLEAN()
    {
        return booleanType;
    }

    /** the Cypher type BYTES */
    @Override
    public Type BYTES()
    {
        return bytesType;
    }

    /** the Cypher type STRING */
    @Override
    public Type STRING()
    {
        return stringType;
    }

    /** the Cypher type NUMBER */
    @Override
    public Type NUMBER()
    {
        return numberType;
    }

    /** the Cypher type INTEGER */
    @Override
    public Type INTEGER()
    {
        return integerType;
    }

    /** the Cypher type FLOAT */
    @Override
    public Type FLOAT()
    {
        return floatType;
    }

    /** the Cypher type LIST */
    @Override
    public Type LIST()
    {
        return listType;
    }

    /** the Cypher type MAP */
    @Override
    public Type MAP()
    {
        return mapType;
    }

    /** the Cypher type NODE */
    @Override
    public Type NODE()
    {
        return nodeType;
    }

    /** the Cypher type RELATIONSHIP */
    @Override
    public Type RELATIONSHIP()
    {
        return relationshipType;
    }

    /** the Cypher type PATH */
    @Override
    public Type PATH()
    {
        return pathType;
    }

    @Override
    public Type POINT_2D()
    {
        return point2dType;
    }

    @Override
    public Type POINT_3D()
    {
        return point3dType;
    }

    @Override
    public Type DATE()
    {
        return dateType;
    }

    @Override
    public Type TIME()
    {
        return timeType;
    }

    @Override
    public Type LOCAL_TIME()
    {
        return localTimeType;
    }

    @Override
    public Type LOCAL_DATE_TIME()
    {
        return localDateTimeType;
    }

    @Override
    public Type DATE_TIME()
    {
        return dateTimeType;
    }

    @Override
    public Type DURATION()
    {
        return durationType;
    }

    /** the Cypher type NULL */
    @Override
    public Type NULL()
    {
        return nullType;
    }

    private TypeRepresentation constructType( TypeConstructor tyCon )
    {
        return new TypeRepresentation( tyCon );
    }
}
