<div style="text-align: center">
    <#if hasPrev>
        <a id="loadPrev" class="btn btn-outline-info" href="${prevPageLink!''}">&lt;&lt;&lt;previousPage</a>
    <#else>
        <span class="btn btn-outline-info" id="loadPrev">previousPage</span>
    </#if>

    <#if hasNext>
        <a id="loadNext" class="btn btn-outline-info" href="${nextPageLink!''}" data-default-page-size="${defaultPageSize!5}">nextPage&gt;&gt;&gt;</a>
    <#else>
        <span class="btn btn-outline-info">nextPage</span>
    </#if>
        <br><br><br>
<#--       <div><a href="/" class="btn btn-outline-info ">Go to the main</a></div>-->
</div>