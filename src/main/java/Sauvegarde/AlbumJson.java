package Sauvegarde;

import Discotheque.Modele.CompactDisque;
import Discotheque.Modele.DisqueVinyle;
import Discotheque.Modele.FichierNumerique;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "support")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CompactDisque.class, name = "cd"),
        @JsonSubTypes.Type(value = DisqueVinyle.class, name = "vinyle"),
        @JsonSubTypes.Type(value = FichierNumerique.class, name = "mp3")
})
abstract class AlbumJson { }