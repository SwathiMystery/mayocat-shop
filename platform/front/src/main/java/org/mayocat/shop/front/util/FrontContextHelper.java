package org.mayocat.shop.front.util;

import java.util.UUID;

import javax.annotation.Nullable;

import org.mayocat.image.model.Thumbnail;
import org.mayocat.model.Attachment;
import org.mayocat.model.HasFeaturedImage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * Helper for front context builders.
 *
 * @version $Id$
 */
public class FrontContextHelper
{
    public static Function<HasFeaturedImage, UUID> ENTITY_FEATURED_IMAGE = new Function<HasFeaturedImage, UUID>()
    {
        @Override
        public UUID apply(final HasFeaturedImage entity)
        {
            return entity.getFeaturedImageId();
        }
    };

    public static Predicate<? super Attachment> isEntityFeaturedImage(final HasFeaturedImage entity)
    {
        return new Predicate<Attachment>()
        {
            public boolean apply(@Nullable Attachment attachment)
            {
                return attachment.getId().equals(entity.getFeaturedImageId());
            }
        };
    }

    public static Predicate<? super Thumbnail> isThumbnailOfAttachment(final Attachment attachment)
    {
        return new Predicate<Thumbnail>()
        {
            @Override
            public boolean apply(@Nullable Thumbnail thumbnail)
            {
                return thumbnail.getAttachmentId().equals(attachment.getId());
            }
        };
    }
}
