<#import "partials/main.ftlh" as main />
<@main.renderWith title="Chat" scripts=["main.js"]>

    <div class="card text-center mb-1">
        <div class="card-header">
            ${chat.name}
        </div>
        <div class="card-body">
            <#list mess as m>
                             <p>${m.user} ${m.time} </p>
                            <p> ${m.text} </p>
            </#list>
            <form action="/add" method="post" >
                <#if _csrf??>
                    <input type="hidden"  name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <input type="hidden" name="chat_id" value="${chat.id}"/>
                <input type="text" name="text" id="title" class="form-control mb-2  mx-sm-3"  placeholder="Messgae" required>
                <button type="submit" class="btn btn-outline-info mb-2" >Send</button>

            </form>
        </div>
        <div class="card-footer text-muted">
${chat.time}        </div>
    </div>

    <br><br><br>

    <#include "partials/pagination.ftlh">
</@main.renderWith>