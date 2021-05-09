class NoteService {
    var notes = mutableListOf<Note>()
    var deleteNote = mutableListOf<Note>()
    var deleteComments = mutableListOf<CommentsNote>()
    var notesID = mutableListOf<Int>()
    var commentsID = mutableListOf<Int>()
    var comments = mutableListOf<CommentsNote>()

    fun createComment(comment: CommentsNote): Boolean {
        if (comment.noteID in notesID) {
            comments.add(comment)
            val idComments = if (notes.isNotEmpty()) notes.last().id + 1 else 1
            commentsID.add(idComments)
            val note = notes.get(comment.noteID - 1)
            note.comments++
            return true
        } else {
            throw NoteNotFoundException("Note Not Found")
        }
    }

    fun addNote(note: Note): Note {
        val idNote = if (notes.isNotEmpty()) notes.last().id + 1 else 1
        notes.add(note)
        notesID.add(idNote)
        return note
    }

    fun deleteNote(note: Note): Boolean {
        if (note.id in notesID) {
            notes.remove(note)
            notesID.remove(note.id)
            deleteNote.add(note)
            return true
        } else {
            throw NoteNotFoundException("Note Not Found")
        }
    }

    fun deleteComment(comment: CommentsNote): Boolean {
        if (comment.noteID in notesID) {
            comments.remove(comment)
            deleteComments.add(comment)
            commentsID.remove(comment.noteID)
            val note = notes.get(comment.noteID - 1)
            note.comments--
            return true
        } else {
            throw NoteNotFoundException("Note Not Found")
        }
    }

    fun editNote(note: Note): Boolean {
        if (note in notes) {
            note.text = note.text
            note.title = note.title
            return true
        } else if (note in deleteNote) {
            throw FindDeleteNoteException("try edit deleted note")
        } else {
            throw NoteNotFoundException("Note Not Found")
        }
    }

    fun editComment(comment: CommentsNote): Boolean {
        if (comment.noteID in notesID) {
            comment.message = comment.message
            return true
        } else if (comment in deleteComments) {
            throw FindDeleteNoteException("try edit deleted comment")
        } else {
            throw NoteNotFoundException("Note Not Found")
        }
    }

    fun getNotes() {
        notes.toList()
        println("$notes")
    }

    fun getComments() {
        comments.toList()
        println("$comments")
    }

}