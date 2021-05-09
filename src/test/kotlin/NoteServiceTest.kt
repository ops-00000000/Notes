import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*



internal class NoteServiceTest {

    @Test
    fun createComment() {
        val note= Note(1,1,"..","...",".....",0)
        val commentsNote = CommentsNote(1,1,"...")
        val service = NoteService()
        service.addNote(note)
        service.createComment(commentsNote)
        val actual = service.comments.last()
        assertEquals(commentsNote,actual)
    }

    @Test
    fun addNoteTest() {
        val note= Note(1,1,"..","...",".....",0)
        val service = NoteService()
        service.addNote(note)
        val actual = service.notes.last()
        assertEquals(note,actual)
    }

    @Test
    fun deleteNote() {
        val note= Note(1,1,"..","...",".....",0)
        val commentsNote = CommentsNote(1,1,"...")
        val service = NoteService()
        service.addNote(note)
        service.createComment(commentsNote)
       val actual = service.deleteNote(note)
        assertTrue(actual)
       val actual1 = service.deleteNote.last()
        assertEquals(note,actual1)

    }

    @Test
    fun deleteComment() {
        val note= Note(1,1,"..","...",".....",0)
        val commentsNote = CommentsNote(1,1,"...")
        val service = NoteService()
        service.addNote(note)
        service.createComment(commentsNote)
        val actual = service.deleteComment(commentsNote)
       val actual1 = service.deleteComments.last()
        assertTrue(actual)
        assertTrue(service.comments.isEmpty())
        assertEquals(commentsNote,actual1)
    }

    @Test
    fun editNote() {
        val note= Note(1,1,"..","...",".....",0)
        val service = NoteService()
        service.addNote(note)
        val actual = service.editNote(note)
        assertTrue(actual)
    }

    @Test
    fun editComment() {
        val note= Note(1,1,"..","...",".....",0)
        val commentsNote = CommentsNote(1,1,"...")
        val service = NoteService()
        service.addNote(note)
        service.createComment(commentsNote)


    }

    @Test
    fun getNotes() {
        val note= Note(1,1,"..","...",".....",0)
        val service = NoteService()
        service.addNote(note)
        val actual = service.getNotes()
        assertEquals(println("$note"),actual)
    }

    @Test
    fun getComments() {
        val note= Note(1,1,"..","...",".....",0)
        val commentsNote = CommentsNote(1,1,"...")
        val service = NoteService()
        service.addNote(note)
        service.createComment(commentsNote)
        val actual = service.getComments()
        assertEquals(println("$commentsNote"),actual)
    }
}