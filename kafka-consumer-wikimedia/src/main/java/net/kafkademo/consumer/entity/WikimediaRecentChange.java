package net.kafkademo.consumer.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="wikimedia_recent_change")
@Data
public class WikimediaRecentChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    private String wikiEventData;

}
