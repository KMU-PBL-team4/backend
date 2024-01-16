package com.example.kmupbl3.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAD is a Querydsl query type for AD
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAD extends EntityPathBase<AD> {

    private static final long serialVersionUID = -589471526L;

    public static final QAD aD = new QAD("aD");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final StringPath description = createString("description");

    public final DateTimePath<java.sql.Timestamp> end_exposure = createDateTime("end_exposure", java.sql.Timestamp.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.sql.Timestamp> reg_date = createDateTime("reg_date", java.sql.Timestamp.class);

    public final StringPath shortHeading = createString("shortHeading");

    public final DateTimePath<java.sql.Timestamp> start_exposure = createDateTime("start_exposure", java.sql.Timestamp.class);

    public final StringPath title = createString("title");

    public QAD(String variable) {
        super(AD.class, forVariable(variable));
    }

    public QAD(Path<? extends AD> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAD(PathMetadata metadata) {
        super(AD.class, metadata);
    }

}

