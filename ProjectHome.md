# **Overview** #

> The goal of the project is to build a social photo sharing application, PhotoZee. Users (who may include professors, students, and other users) will have friend networks (organized in the form of circles), and will upload their photos.  Users will be able to log into the system, see recommended photos, and also visually browse their friends, friends’ friends, and advisors’ / advisees’ networks to see what photos each such person has posted.  Moreover, there will be search capabilities whereby a user may try to find images matching keywords.

# **Features:** #

**1. Users and user profiles:**
> Users will register profiles with the system, including personal information -- at least first and last name, email, birth date, gender, address, academic institutions attended, and whether they are a professor or student.  Professors should have a list of advisees and students should have an advisor.  If a professor or a student registers an advisor/advisee relationship, the symmetric entry should also be captured.  i.e., if a Student Y says she is advised by Professor X, then Professor X should be given an entry saying she advises Student Y.

**2. Login page:**
> There should be a login page where the user types in his/her account ID and password.

**3. Friends and Circles:**
> Users have sets of friends registered on the system. Every friend must be in one or more circles.  A circle has an ID and a name.  It may be empty.

**4. Photo posting:**
> Users may post photos by registering a URL. They may also tag (add relevant keywords to) and rate the photo, as below.  The photo will be posted with a particular visibility -- it should be seen by Everyone, a list of users, or a list of circles.

**5. Photo tagging and rating:**
> It should be possible for anyone who can see a photo to tag it with further keywords, or to rate the photo (1 to 5 stars).

**6. Photo search:**
> Users should be able to search among the photos they can see, based on keywords (which match tags).  The photo search capability should be based on tables storing an inverted index:  a table mapping from keywords to matching photos.  Results should be returned in inverse order of relevance (see below).

**7. Photo relevance scoring:**
> Given a user, a photo, the photo’s “owner”, and a set of ratings, it must be possible to score the relevance of the photo.  A photo is more relevant if it has a higher average rating.  It should also be more relevant if it comes from a friend, or was rated highly by friends.  There is significant room to be creative here!

**8. User home page:**
> When the user logs in, he or she should see: (1) a grid of top-scoring photos, according to the relevance score above, (2) a list of recent updates about which friends have posted photos (and the related tags), (3) an area where he or she can browse his or her friend network, (4) a list of recommended friends.  Some of these may be in pop-up dialog boxes as appropriate.  See below.

**9. Friendship browser:**
> The friendship browser should build upon the JIT toolkit to allow the user to see friends, friends’ photos, and friends of friends.  It should also extend to advisors/advisees.  The network should only be browsable to 2 hops from the user.

**10. Friend recommendations:**
> The system should make recommendations for friends based on (1) common friends-of-friends, (2) common ratings of the same photos.