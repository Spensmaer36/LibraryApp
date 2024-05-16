<#import "../layout.ftlh" as main>
<@main.layout>
    <h1>Search Books</h1>
    <form action="/search" method="get">
        <input type="text" name="keyword" value="${keyword?if_exists}" placeholder="Enter book title"/>
        <button type="submit">Search</button>
    </form>

    <#if searchResults?? && (searchResults?size > 0)>
        <h2>Search Results:</h2>
        <ul>
            <#list searchResults as book>
                <div class="col m-2">
                    <div class="card" style="width: 18rem; min-height: 200px">
                        <div class="card-header">
                            <h5 class="card-title">${book.title}</h5>
                        </div>
                        <div class="card-body">
                            <p class="card-text"> ${book.description}</p>
                            <p class="card-text">Author: ${author.getAuthorById(book.authorId).name}</p>
                            <p class="card-text">Release Date: ${book.releaseDate}</p>
                        </div>
                        <div class="card-footer">
                            <a type="button" class="btn btn-primary" href="journal/add/${book.id}">Give it to Reader</a>
                        </div>
                    </div>
                </div>
            </#list>
        </ul>
    <#else>
        <p>No results found</p>
    </#if>
</@main.layout>