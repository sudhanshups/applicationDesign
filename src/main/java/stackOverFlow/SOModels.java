package stackOverFlow;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SOModels {
    public static void main(String[] args) {


    }
}

enum AccountStatus {
    ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
}

enum VoteType {
    UPVOTE, DOWNVOTE;
}

enum PostType {
    QUESTION, ANSWER, COMMENT;
}

enum Badge {
    CURIOUS, INVESTOR;
}

class System {
    private static Map<String, Integer> tagsFrequency = new HashMap<>();

    public void increaseTagFrequency(String tag) {
        if (!tagsFrequency.containsKey(tag)) {
            tagsFrequency.put(tag, 0);
        }
        tagsFrequency.put(tag, tagsFrequency.get(tag) + 1);
    }

    public Set<String> getTopKTags(Integer k) {
        return null;
    }
}

class Tag {
    private Set<String> tags;
    private System system;

    Tag(System system) {
        this.system = system;
    }

    public boolean add(String tag) {
        tags.add(tag);
        system.increaseTagFrequency(tag);
        return true;
    }

    public Set<String> getTags() {
        return tags;
    }
}

class Guest {
    boolean registerAccount() {
        return true;
    }
}

@Data
class Member extends Account {
    private List<Badge> badge;

    void vote(Post post, VoteType voteType) {
        post.vote(voteType);
    }

    void flag(Post post) {
        post.flagReported++;
    }

    Integer addBounty(Question question, Integer bounty) {
        question.bounty += bounty;
        return question.bounty;
    }

    Integer voteToCloseQuestion(Question question) {
        return question.voteToClose();
    }

    Integer voteToDeleteQuestion(Question question) {
        return question.voteToDelete();
    }

    boolean postQuestion(Question question) {
        return true;
    }// same for delete que

    boolean postAnswer(Answer answer) {
        return true;
    }// same for delete Ans

    boolean addComment(Comment comment) {
        return true;
    }// same for delete comment

    boolean resetPassword() {
        return true;
    }
}

class Admin extends Member {
    public boolean blockMember(Member member) {
        member.setStatus(AccountStatus.BLOCKED);
        return true;
    }

    public boolean unblockMember(Member member) {
        member.setStatus(AccountStatus.ACTIVE);
        return true;
    }
}

class Moderator extends Member {
    public boolean closeQuestion(Question question) {
        question.setClosed(true);
        return true;
    } //same for Open

    public boolean unDeleteQuestion(Question question) {
        question.setDeleted(false);
        return true;
    }//same for delete
}

interface Vote {
    Integer getId();

    PostType getPostType();

    void vote(VoteType voteType);
}

abstract class Post implements Vote {
    Integer id;
    Integer parentId;
    PostType postType;

    Integer upvotes;
    Integer downVotes;
    Integer flagReported;

    String description;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void vote(VoteType voteType) {
        if (VoteType.UPVOTE.equals(voteType)) {
            upvotes++;
        } else {
            downVotes++;
        }
    }
}

@Data
class Question extends Post {
    String title;
    Integer bounty;
    Tag tag;

    Integer closeVotes;
    Integer deleteVotes;

    boolean isClosed;
    boolean isDeleted;

    List<String> imageUrls;


    Question(Tag tag) {
        this.tag = tag;
    }

    @Override
    public PostType getPostType() {
        return PostType.QUESTION;
    }

    Integer voteToClose() {
        return ++closeVotes;
    }

    Integer voteToDelete() {
        return ++deleteVotes;
    }

    void setClosed(boolean a) {
        isClosed = a;
    }

    void setDeleted(boolean a) {
        isDeleted = a;
    }

}

class Answer extends Post {
    boolean isAccepted;
    List<String> imageUrls;

    @Override
    public PostType getPostType() {
        return PostType.ANSWER;
    }
}

class Comment extends Post {
    @Override
    public PostType getPostType() {
        return PostType.COMMENT;
    }
}

