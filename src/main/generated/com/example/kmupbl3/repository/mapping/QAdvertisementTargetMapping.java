package com.example.kmupbl3.repository.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdvertisementTargetMapping is a Querydsl query type for AdvertisementTargetMapping
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdvertisementTargetMapping extends EntityPathBase<AdvertisementTargetMapping> {

    private static final long serialVersionUID = -1953896631L;

    public static final QAdvertisementTargetMapping advertisementTargetMapping = new QAdvertisementTargetMapping("advertisementTargetMapping");

    public final NumberPath<Integer> adId = createNumber("adId", Integer.class);

    public final NumberPath<Integer> featureId = createNumber("featureId", Integer.class);

    public QAdvertisementTargetMapping(String variable) {
        super(AdvertisementTargetMapping.class, forVariable(variable));
    }

    public QAdvertisementTargetMapping(Path<? extends AdvertisementTargetMapping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdvertisementTargetMapping(PathMetadata metadata) {
        super(AdvertisementTargetMapping.class, metadata);
    }

}

