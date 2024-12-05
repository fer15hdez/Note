# Git

…or create a new repository on the command line  

echo "# Note" >> README.md  
git init  
git add README.md  
git commit -m "first commit"  
git branch -M main  
git remote add origin https://github.com/dquijote/Note.git **"origin" is the name of the url.**   
git push -u origin main  

…or push an existing repository from the command line  

git remote add origin https://github.com/dquijote/Note.git  
git branch -M main  
git push -u origin main  


 git clone https://github.com/libgit2/libgit2 **Clone the whole repository**  
 git clone https://github.com/libgit2/libgit2 name_directory **Clone the whole repository in diferent directory "name_directory"**  
 git status #Show the status of each file  
 git add path_file or path_dir **Tracked file. Is ready to commit to repository. If is a path_dir all file and dir will be Tracked.**  
 git reset path_file or path_dir **The tracked file or dir is untracked. Delete from tracked, the file is unfollow** 
 git remote -v **Show all the remote repository that are cloned.**   
 git fetch [remote-name] **El comando irá al proyecto remoto y se traerá todos los datos que aun no tienes de dicho remoto, todo lo diferente despues de clonarlo.**    

git push [nombre-remoto] [nombre-rama] **To send the local repository to a server.**    
git push origin master **That put all local repository even with the commit.**    
git config --global credential.helper 'store --file ~/.my-credentials' **Store the credencial in a file. Default is ~/.my-credentials**    
  https://user:pass@example.com **Format in file credentials**  
 git config --global credential.helper 'cache --timeout [seconds]' "Config a credential cache. During all seconds config"  

### Overwrite the local project for the remote project  
git fetch --all # "Dowload all file from remote but not merge"  
### If want to Backup your current branch (e.g. master):  
git branch backup-master  
### Jump to the latest commit on origin/master and checkout those files:  
git reset --hard origin/master "resets the master branch to what you just fetched. The --hard option changes all the files in your working tree to match the files in origin/master."  
git reset [<mode>] [<commit>]  
  This form resets the current branch head to <commit> and possibly updates the index (resetting it to the tree of <commit>) and the working tree depending on <mode>. If <mode> is omitted, defaults to --mixed. The <mode> must be one of the following:
  [--mixed]  
    Resets the index but not the working tree (i.e., the changed files are preserved but not marked for commit) and reports what has not been updated. This is the default action.
  [--soft]  
    Does not touch the index file or the working tree at all (but resets the head to <commit>, just like all modes do). This leaves all your changed files "Changes to be committed", as git status would put it.  
  [--hard]
    Resets the index and working tree. Any changes to tracked files in the working tree since <commit> are discarded.



## Branch
### Create a branch
git branch <name_of_branch>
### Jump to other branch
git switch <name_of_branch>

### Para borrar la branch local
git branch -d localBranchName **-d eliminará la branch únicamente si esta ha sido empujada y fusionada con la branch remota."**    
          "-D si deseas forzar la eliminación de una branch, incluso si aún esta no ha sido empujada o fusionada aún."  

### Para borrar la branch remota
git push origin --delete remoteBranchName "Just need to put remoteBranchName, not a like 'origen/remoteBranchName'. Don't make completion of name of branch"  

git branch -d [ name_branch] "with the -d option is to delete the branch"  
git checkout [name_branch] "Switched to branch [name_branch]" "Updates files in the working tree to match the version in the index or the specified tree"  
git branch "Show the branches and with * said which is selected"  

## Proxy en Git
git config --global http.proxy http://proxyuser:proxypwd@proxy.server.com:8080 " this works for both http and https repos."  
    "change proxyuser to your proxy user"  
    "change proxypwd to your proxy password"  
    "change proxy.server.com to the URL of your proxy server"  
    "change 8080 to the proxy port configured on your proxy server"  
### Reset proxy, work without proxy 
git config --global --unset http.proxy  
#### to check the currently set proxy:
git config --global --get http.proxy  

## REMOTE
git remote: Muestra los nombres de cada uno de los remotos que tienes especificados.  
git remote -v: Muestra las url de los remotos configurados.  


