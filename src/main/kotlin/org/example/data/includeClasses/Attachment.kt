package org.example.data.includeClasses

interface Attachment {
    val type: String

}

class AudioAtachment(val audio: Audio) : Attachment {
    override val type = "audio";
}

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val liricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean,
    val isHq: Boolean
)

class DocumentAtachment(val document: Document) : Attachment {
    override val type = "document";
}

class Document(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val documentType: Int,
    val preview: Preview?
)

class Preview(
    val id: Int
)

class LinkAtachment(val link: Link) : Attachment {
    override val type = "link";
}

class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val photo: Photo?,
    val product: Product?,
    val button: Button?,
    val previewPage: String,
    val previewUrl: String,
)

class Button(
    val id: Int
)

class Product(
    val id: Int
)

class PhotoAtachment(val photo: Photo) : Attachment {
    override val type = "photo";
}

class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<CopyPhoto>?,
    val width: Int,
    val height: Int
)

class CopyPhoto(
    val id: Int,
    val type: String,
    val url: String,
    val width: Int,
    val height: Int
)

