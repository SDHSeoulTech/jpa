package com.example.jpa.domain.post.tag.entity;

import com.example.jpa.domain.post.post.entity.Post;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Tag {
    @EmbeddedId
    private TagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Include
    @MapsId("postId")
    private Post post;
}